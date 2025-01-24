package com.goldtek.edi_serv.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldtek.edi_serv.entity.edi.FileMetadata;
import com.goldtek.edi_serv.entity.erp.SalesOrderDetailData;
import com.goldtek.edi_serv.entity.erp.SalesOrderHeadData;
import com.goldtek.edi_serv.repostory.edi.FileMetadataRepository;
import com.goldtek.edi_serv.repostory.erp.SalesOrderRepository;

import io.xlate.edi.stream.EDIOutputFactory;
import io.xlate.edi.stream.EDIStreamConstants;
import io.xlate.edi.stream.EDIStreamWriter;
@Service
public class Edi855ServiceImpl implements Edi855Service{
	private static final Logger log = LogManager.getLogger(Edi855ServiceImpl.class);
	
	@Autowired
	private FileMetadataRepository fileMetadataRepository;
	
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	@Override
	public List<SalesOrderHeadData> get855FromErp() {
		log.info("Find 855 Data from Workflow ERP...");
		
		//抓客戶為champerlen and 客戶單號不為NULL且已簽核、未拋轉
		List<SalesOrderHeadData>  list = salesOrderRepository.findByCustomerNoEqualsAndConfirmCodeIsAndSyncStatusIs("A001","Y","0");
		log.info("A total of {} records found.:",list.size());
		for(SalesOrderHeadData h:list) {
			log.info("ID:"+h.getId());
		}
		return list;
		
	}
	
	@Override
	public void convertToUdfFile(List<SalesOrderHeadData> list) {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		for (SalesOrderHeadData head : list) {// 一個Head寫一個檔案
			try {
				
				FileMetadata file855Metadata = new FileMetadata();
				file855Metadata.setFileType("855");
				file855Metadata.setReceivedTime(ldt);
				
				
				List<FileMetadata>  r = fileMetadataRepository.findFileMetadataByCustomerDocno(head.getCustomerDocNo());
				FileMetadata fileMetadata = r.get(0);//取得850資訊
				List<FileMetadata>  list855 = fileMetadataRepository.findFileMetadataByFileTypeOrderByIsaControlNumberDesc("855");
				String isaController855 = list855.size()==0?"000000000":list855.get(0).getIsaControlNumber();
				int isanumber = Integer.parseInt(isaController855);//要改
				String newIsaControlNumber = String.format("%09d", ++isanumber);
				// (1) Create an EDIOutputFactory
				EDIOutputFactory factory = EDIOutputFactory.newFactory();
				// Obtain Stream write the EDI document.
				OutputStream stream = new FileOutputStream("D:\\edi-test" + System.currentTimeMillis() + ".txt");
				int groupCount = 0;
				// (2) Optionally specify delimiters - here the given values are the same as
				// default
				factory.setProperty(EDIStreamConstants.Delimiters.SEGMENT, '~');
				factory.setProperty(EDIStreamConstants.Delimiters.DATA_ELEMENT, '*');

				// Write each segment on a new line
				factory.setProperty(EDIOutputFactory.PRETTY_PRINT, true);

				// (3) Create an EDIStreamWriter. Any OutputStream may be used - here we are
				// writing to the console
				EDIStreamWriter writer = factory.createEDIStreamWriter(System.out);

				// (4) Start the interchange
				writer.startInterchange();
				int i = 0;
				// (5) Write the three segments necessary for the interchange acknowledgement
				// (ISA, TA1, IEA)
				writer.writeStartSegment("ISA")
						.writeElement("00")// 授權資訊類型
						.writeElement("          ")// 授權資訊
						.writeElement("00")// 安全資訊類型
						.writeElement("          ")// 安全資訊
						.writeElement("01")// 發送者識別碼類型
						.writeElement(fileMetadata.getReceiverId())// 發送者識別碼
						.writeElement("ZZ")// 接收者識別碼類型
						.writeElement(fileMetadata.getSenderId())// 接收者識別碼
						.writeElement("250102")// 文件生成日期-系統產生
						.writeElement("1000")// 文件生成時間-系統產生
						.writeElement("U")// 控制標識
						.writeElement("00401")// 版本號
						.writeElement(newIsaControlNumber)// 控制號 "000000002"
						.writeElement("0")// 回應請求標識(無需回應)
						.writeElement("T")// 用途標識
						.writeElement(">")// 分隔符識別碼
						.writeEndSegment();
				file855Metadata.setSenderId(fileMetadata.getReceiverId());
				file855Metadata.setReceiverId(fileMetadata.getSenderId());
				file855Metadata.setIsaControlNumber(newIsaControlNumber);
			
				
				
				
				i++;
				writer.writeStartSegment("GS")// 功能組
						.writeElement("IN")// 功能組代碼
						.writeElement("GTec")// 發送者代碼
						.writeElement("PARTNER001")// 接收者代碼，交易夥伴的 EDI ID
						.writeElement("20250121")// 功能組生成日期
						.writeElement("1234")// 功能組生成時間
						.writeElement("1")// 功能組控制號
						.writeElement("X12")// 負載標準代碼(ASC X12)
						.writeElement("004010")// 版本/釋放編號
						.writeEndSegment();
				file855Metadata.setGsControlNumber("1");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate dt = LocalDate.parse("20250121",formatter);
				file855Metadata.setDocumentDate(dt);
				
				i++;
				writer.writeStartSegment("ST")
				.writeElement("855")
				.writeElement("0001")
				.writeEndSegment();
				i++;

				
				file855Metadata.setStControlNumber("0001");
				
				
				
				writer.writeStartSegment("BAK")// 功能組
				.writeElement("00")// "00" - Original
				.writeElement("AC")// "AC" - Acknowledge - With Detail and Change
				.writeElement(head.getCustomerDocNo())//PO 單號
				.writeElement(head.getOrderDate())// 
				.writeEndSegment();
				i++;
				
				
				
				writer.writeStartSegment("REF")
				.writeElement("IT")//Internal Customer Order Number
				.writeElement(head.getId().getSoNo())
				.writeEndSegment();
				i++;
				BigDecimal totalCount = BigDecimal.ZERO;
				
				for(SalesOrderDetailData detail:head.getDetails()) {
					writer.writeStartSegment("PO1")
					.writeElement(detail.getId().getSoSeq())//Purchase Order Line number
					.writeElement(detail.getOrderQty().toString())
					.writeElement(detail.getUnit())
					.writeElement(detail.getPrice().toString())
					.writeElement("PE")
					.writeElement("BP")
					.writeElement(detail.getCustomerItem())
					.writeElement("VP")
					.writeElement(detail.getItemNo())
					.writeEndSegment();
					i++;	
					totalCount = totalCount.add(detail.getOrderQty());
					
					writer.writeStartSegment("ACK")
					.writeElement("IA")//Internal Customer Order Number
					.writeElement(detail.getOrderQty().toString())
					.writeElement(detail.getUnit())
					.writeElement("017")
					.writeElement(detail.getPlanDeliveryDate())
					.writeEndSegment();
					i++;
				}
				writer.writeStartSegment("CTT")
				.writeElement(totalCount.toString())
				.writeEndSegment();

				// Write functional group header segment
				groupCount++;
				int txCount = 0;
				writer.writeStartSegment("SE").writeElement(i + "").writeElement("0001").writeEndSegment();
				txCount++;
				// Continue writing remainder of group header and transactions, increment
				// `txCount` for each transaction

				writer.writeStartSegment("GE")
						/* Count of transactions here must match the actual count of ST/SE pairs */
						.writeElement(String.valueOf(txCount))
						/* Control number here must match the value in the group header */
						.writeElement("1").writeEndSegment();

				writer.writeStartSegment("IEA")
						/* Count of groups here must match the actual count of GS/GE pairs */
						.writeElement(String.valueOf(groupCount))
						/* Control number here must match the value in the interchange header */
						.writeElement("000000001").writeEndSegment();

				// (6) End the interchange
				writer.endInterchange();

				// (7) Close the EDIStreamWriter. This must be done to ensure the output is
				// written
				writer.close();
				
				file855Metadata.setStatus("Sent");
				fileMetadataRepository.save(file855Metadata);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//更新狀態為已拋轉1

			int updateCnt = salesOrderRepository.updateSyncStatusTo1ById(head.getId().getSoTypeNo(),head.getId().getSoNo());
			
			log.info("updateCnt:"+updateCnt);
		}
	}

}

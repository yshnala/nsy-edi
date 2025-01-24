package com.goldtek.edi_serv.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldtek.edi_serv.api.entity.SalesOrderDetailData;
import com.goldtek.edi_serv.api.entity.SalesOrderHeadData;
import com.goldtek.edi_serv.entity.edi.FileMetadata;
import com.goldtek.edi_serv.entity.edi.OrderMapping;
import com.goldtek.edi_serv.entity.erp.ExchangeRateDetail;
import com.goldtek.edi_serv.entity.erp.SalesOrderHeadDataId;
import com.goldtek.edi_serv.repostory.edi.FileMetadataRepository;
import com.goldtek.edi_serv.repostory.edi.OrderMappingRepository;
import com.goldtek.edi_serv.repostory.erp.ExchangeRateRepository;
import com.goldtek.edi_serv.repostory.erp.SalesOrderRepository;

import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIOutputFactory;
import io.xlate.edi.stream.EDIStreamConstants;
import io.xlate.edi.stream.EDIStreamException;
import io.xlate.edi.stream.EDIStreamReader;
import io.xlate.edi.stream.EDIStreamWriter;

/**
 * 發票作業
 */
@Service
public class Edi850ServiceImpl implements Edi850Service{
	
	private static final Logger log = LogManager.getLogger(Edi850Service.class);
	
	@Autowired
	private OrderMappingRepository orderMappingRepository; 
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private SalesOrderApiService salesOrderApiService;
	
	@Autowired
	private FileMetadataRepository fileMetaDataRepository;
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	@Override
	public void getInvoiceFromErp() {


	}

	@Override
	public void convertToUdfFile() {
		  try {
				// (1) Create an EDIOutputFactory
				EDIOutputFactory factory = EDIOutputFactory.newFactory();
				// Obtain Stream write the EDI document.
				OutputStream stream = new FileOutputStream("D:\\edi-test1.txt");
				int groupCount = 0;
				// (2) Optionally specify delimiters - here the given values are the same as default
				factory.setProperty(EDIStreamConstants.Delimiters.SEGMENT, '~');
				factory.setProperty(EDIStreamConstants.Delimiters.DATA_ELEMENT, '*');

				// Write each segment on a new line
				factory.setProperty(EDIOutputFactory.PRETTY_PRINT, true);

				// (3) Create an EDIStreamWriter. Any OutputStream may be used - here we are writing to the console
				EDIStreamWriter writer = factory.createEDIStreamWriter(System.out);

				// (4) Start the interchange
				writer.startInterchange();
				int i=0;
				// (5) Write the three segments necessary for the interchange acknowledgement (ISA, TA1, IEA)
				writer.writeStartSegment("ISA")
				      .writeElement("00")//授權資訊類型
				      .writeElement("          ")//授權資訊
				      .writeElement("00")//安全資訊類型
				      .writeElement("          ")//安全資訊
				      .writeElement("01")//發送者識別碼類型
				      .writeElement("081174492TEST  ")//發送者識別碼
				      .writeElement("ZZ")//接收者識別碼類型
				      .writeElement("UVCBGXTWTPE0031")//接收者識別碼
				      .writeElement("250102")//文件生成日期
				      .writeElement("0940")//文件生成時間
				      .writeElement("U")//控制標識
				      .writeElement("00401")//版本號
				      .writeElement("000000001")//控制號
				      .writeElement("0")//回應請求標識(無需回應)
				      .writeElement("T")//用途標識
				      .writeElement(">")//分隔符識別碼
				      .writeEndSegment();
				i++;
				writer.writeStartSegment("GS")//功能組
				      .writeElement("IN")//功能組代碼
				      .writeElement("GTec")//發送者代碼
				      .writeElement("PARTNER001")//接收者代碼
				      .writeElement("20250108")//功能組生成日期
				      .writeElement("1234")//功能組生成時間
				      .writeElement("1")//功能組控制號
				      .writeElement("X")//負載標準代碼(ASC X12)
				      .writeElement("004010")//版本/釋放編號
				      .writeEndSegment();
				i++;
				writer.writeStartSegment("ST")
				      .writeElement("810")
				      .writeElement("INV001")
				      .writeEndSegment();
				i++;		
				
				writer.writeStartSegment("REF")
			      .writeElement("IT")
			      .writeElement("NET30")
			      .writeEndSegment();
				i++;	
				writer.writeStartSegment("N1")
			      .writeElement("BY")
			      .writeElement("Buyer Name")
			      .writeEndSegment();
				i++;
				
				writer.writeStartSegment("IT1")
			      .writeElement("0010")
			      .writeElement("10")
			      .writeElement("EA")
			      .writeElement("25.00")
			      .writeElement("VP")
			      .writeElement("WIDGET")
			      .writeEndSegment();
				i++;
				writer.writeStartSegment("IT1")
			      .writeElement("0020")
			      .writeElement("5")
			      .writeElement("EA")
			      .writeElement("50.00")
			      .writeElement("VP")
			      .writeElement("GADGET")
			      .writeEndSegment();
				i++;
				
				//總金額
				writer.writeStartSegment("TDS")
			      .writeElement("50000")
			      .writeEndSegment();
				i++;
				
				
				
				
				
				// Write functional group header segment
				groupCount++;
				int txCount = 0;
				writer.writeStartSegment("SE")
				  .writeElement(i+"")
				  .writeElement("0001")
			      .writeEndSegment();
				txCount++;
				// Continue writing remainder of group header and transactions, increment `txCount` for each transaction

				writer.writeStartSegment("GE")
				      /* Count of transactions here must match the actual count of ST/SE pairs */
				      .writeElement(String.valueOf(txCount))
				      /* Control number here must match the value in the group header */
				      .writeElement("1") 
				      .writeEndSegment();

				writer.writeStartSegment("IEA")
				      /* Count of groups here must match the actual count of GS/GE pairs */
				      .writeElement(String.valueOf(groupCount))
				      /* Control number here must match the value in the interchange header */
				      .writeElement("000000001")
				      .writeEndSegment();
				
				// (6) End the interchange
				writer.endInterchange();

				// (7) Close the EDIStreamWriter. This must be done to ensure the output is written
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e.toString());
			}
			
	}

	


	/**
	 * 
	 * @title: 讀850文件
	 * @author: alan_huang
	 * @since: 2025年1月20日 上午8:58:24
	 */
	@Override
	public void read850() {
		EDIInputFactory factory = EDIInputFactory.newFactory();
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		List<SalesOrderHeadData> headList = new ArrayList();
		try {
			// 抓850文件
			InputStream stream = new FileInputStream("D:\\2025_workspace\\Goldtek_test_PO2.txt");

			// 初始化
			String planDeliveryDate = "";// 預交日
			String current = "";// 紀錄現在在哪
			int i = 0;// 紀錄是第幾項
			SalesOrderHeadData head = new SalesOrderHeadData();
			List<SalesOrderDetailData> list = new ArrayList();
			BigDecimal totalAmount = BigDecimal.ZERO;// 總價格
			BigDecimal totalCount = BigDecimal.ZERO;// 總數量
			BigDecimal count = BigDecimal.ZERO;
			int poItemCount = 0;// 第幾個Detail
			SalesOrderDetailData detail = new SalesOrderDetailData();
			FileMetadata fileMetaData = new FileMetadata();
			fileMetaData.setFileType("850");
			fileMetaData.setReceivedTime(ldt);
			String sender = "";
			String receiver = "";
			String isaControlNumber = "";
			String gsControlNumber = "";
			String stControlNumber = "";
			LocalDate gs4;
			List<OrderMapping> orderList = new ArrayList();

			// 讀取EDI文件
			EDIStreamReader reader = factory.createEDIStreamReader(stream);
			while (reader.hasNext()) {
				boolean isPoItem = false;
				BigDecimal money = BigDecimal.ZERO;
				BigDecimal amount = BigDecimal.ZERO;
				
				switch (reader.next()) {
				case START_INTERCHANGE:
					String standard = reader.getStandard();
					String[] version = reader.getVersion();
					break;

				case START_SEGMENT:
					// Retrieve the segment name - e.g. "ISA" (X12), "UNB" (EDIFACT), or "STX"
					// (TRADACOMS)
					String segmentName = reader.getText();
					System.out.println("segmentName:" + segmentName + ",i=" + i);
					current = segmentName;
					if (segmentName.equals("PO1_1"))
						detail = new SalesOrderDetailData();

					detail.setPlan_delivery_date(planDeliveryDate);
					break;

				case END_SEGMENT:
					i = 0;
					break;

				case START_COMPOSITE:
					break;

				case END_COMPOSITE:
					break;

				case ELEMENT_DATA:
					i++;
					String data = reader.getText();
					String key = current + "_" + i;
					System.out.println(key + ":" + data);
					switch (key) {
					case "ISA_6":// 發送方
						fileMetaData.setSenderId(data);
						sender = data;
						break;
					case "ISA_8":// 接收方
						fileMetaData.setReceiverId(data);
						receiver = data;
						break;
					case "ISA_13":// ISA控制碼
						fileMetaData.setIsaControlNumber(data);
						isaControlNumber = data;
						break;
					case "GS_6":// GS控制碼
						fileMetaData.setGsControlNumber(data);
						gsControlNumber = data;
						break;
					case "GS_4":// 日期
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate dt = LocalDate.parse(data, formatter);
						gs4 = dt;
						fileMetaData.setDocumentDate(dt);
						break;
					case "ST_2":// ST控制碼
						fileMetaData.setStControlNumber(data);
						stControlNumber = data;
						break;
					case "BEG_1":// 單別00 表示原始訂單 01 表示取消訂單 02 表示修改訂單 05 表示替換訂單
						head.setSo_type_no("2201");//單別
						break;
					case "BEG_2":
						break;
					case "BEG_3":// 採購訂單號碼
						head.setCustomer_doc_no(data);
						OrderMapping order = new OrderMapping();
						order.setPoNumber(data);
						order.setFileType("850");
						order.setIsaControlNumber(isaControlNumber);
						order.setGsControlNumber(gsControlNumber);
						order.setStControlNumber(stControlNumber);
						orderList.add(order);
						break;
					case "BEG_5":// 採購日期
						head.setOrder_date(data);
						break;
					case "CUR_1":
						break;
					case "CUR_2":// 幣別
						head.setTrans_currency(data);
						break;
					case "REF_2"://
						// 內部供應商編號???????????????????????????????????
						break;
					case "ITD_1":// 指定付款條件類型的代碼。常見值：01 = 標準 05 = 日期基準折扣 14 = 延期付款
						break;
					case "ITD_2":// 確定付款條件起算的基準日期 3 = 發票日期 15 = 收貨日期
						break;
					case "ITD_7":// 全額支付應付款項的最後期限天數，例如 60 天
						break;
					case "DTM_1":// 指定日期或時間的類型代碼 002 送貨日期 預交日?
						break;
					case "DTM_2":
						planDeliveryDate = data;
						break;
					case "N3_1":
						head.setDelivery_address1(data);
						break;
					case "N4_1":// 城市名稱
						break;
					case "N4_2":// 州代號
						break;
					case "N4_3":// 郵遞區號
						break;
					case "N4_4":
						head.setShipping_country_name(data);
						break;
					case "PO1_1":
						isPoItem = true;
						poItemCount++;
						detail.setSo_seq(data);
						detail.setSo_type_no("2201");
						break;
					case "PO1_2":
						count = new BigDecimal(data);
						totalCount.add(new BigDecimal(data));
						detail.setOrder_qty(new BigDecimal(data));
						break;
					case "PO1_3":// 單位
						detail.setUnit("PCS");
						break;
					case "PO1_4":// 單價
						detail.setPrice(new BigDecimal(data));
						amount = count.multiply(new BigDecimal(data));
						detail.setAmount(amount);
						count = BigDecimal.ZERO;
						detail.setClose_code("N");
						detail.setWarehouse_no("W02");
						detail.setGift_qty(BigDecimal.ZERO);
						detail.setDiscount_rate(new BigDecimal(100));
						detail.setGross_weight_kg(BigDecimal.ZERO);
						detail.setCuft_size(BigDecimal.ZERO);
						detail.setSo_packing_qty(BigDecimal.ZERO);
						detail.setGift_packing_qty(BigDecimal.ZERO);
						detail.setSource("9");
						detail.setType("1");
						detail.setPrepare_item_qty(BigDecimal.ZERO);
						detail.setPrepare_item_packing_qty(BigDecimal.ZERO);
						detail.setLock_delivery_date("N");
						detail.setTax_rate(BigDecimal.ZERO);
						detail.setValuation_qty(BigDecimal.ZERO);
						detail.setValuation_unit("PCS");
						detail.setDiscount_amount(BigDecimal.ZERO);
						detail.setExemption_identity("0");
						break;
					case "PO1_5":
						break;
					case "PO1_6":
						break;
					case "PO1_7":
						detail.setCustomer_item(data);
						detail.setItem_no("010186U00-535-G");
						list.add(detail);
						break;
					case "PID_1":// F 表示自由格式描述；S 表示結構化描述等。
						break;
					case "PID_2":// ???
						break;
					case "AMT_2"://
						totalAmount = totalAmount.add(new BigDecimal(data));
						System.out.println("totalAmount:" + totalAmount);
						break;
					case "CTT_1":// PO行數
						poItemCount++;
						break;
					case "CTT_2"://
						totalCount = totalCount.add(new BigDecimal(data));
						break;

					}

					break;
				}

			}
			// 補齊剩餘必填欄位
			completeRequiredFields(head);
			head.setOrder_amount(totalAmount);// 總價
			head.setTot_pqty(totalCount);
			head.setSales_order_detail_data(list);
			headList.add(head);
			
		
			if(salesOrderApiService.create(headList)) {
				fileMetaData.setStatus("RECEIVED");
				fileMetaDataRepository.save(fileMetaData);
				orderMappingRepository.saveAll(orderList);
			}
			
			reader.close();
			stream.close();
		} catch (FileNotFoundException e) {
			log.error(e.toString());
		} catch (EDIStreamException e) {
			log.error(e.toString());
		} catch (IOException e) {
			log.error(e.toString());
		}

	}
	
	
	
	/**
	 * 
	 * @title:補齊剩餘欄位 
	 * @author: alan_huang
	 * @since: 2025年1月22日 上午8:36:18
	 * @param head
	 */
	private void completeRequiredFields(SalesOrderHeadData head) {
		head.setSo_type_no("2201");// 單別
		head.setOm_site_id("001");// 出貨廠別->??
		head.setTax_code("S11");// 稅別->??
		head.setCommission_rate(BigDecimal.ZERO);// 佣金比率
		head.setOrder_tax(BigDecimal.ZERO);// 稅額 = 總金額 * 稅率
		head.setDoc_date("20250120");
		head.setTotal_gross_weight_kg(BigDecimal.ZERO);
		head.setTotal_cuft_size(BigDecimal.ZERO);
		head.setTotal_packing_qty(BigDecimal.ZERO);
		head.setVolume_unit("1");
		head.setTrade_condition("2");// 要設什麼值?? 代表FOB?
		head.setDeposit_instalment("N");
		head.setIncome_postpone_days(new BigDecimal(60));// ?
		head.setNo_credit_limit_control("N");// 不控管信用額度
		head.setTaxed_code("3");// 課稅別->??
		head.setTax_rate(BigDecimal.ZERO);
		head.setDeposit_rate(BigDecimal.ZERO);
		head.setBody_multi_tax_rate("N");// 單身多稅率
		head.setCustomer_no("A001");// 寫死
		head.setSalesman_no("70171");
		
		List<ExchangeRateDetail> results = exchangeRateRepository
				.findByIdCurrOrderByIdEffectiveDateDesc(head.getTrans_currency());
		if (!results.isEmpty())
			head.setExchange_rate(new BigDecimal(results.get(0).getBank_buying_exch_rate()));// 去查匯率By幣別
	}
	
	
	
	
}

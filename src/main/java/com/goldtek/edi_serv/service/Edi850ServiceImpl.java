package com.goldtek.edi_serv.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldtek.edi_serv.entity.Isa;
import com.goldtek.edi_serv.entity.SalesOrderDetailData;
import com.goldtek.edi_serv.entity.SalesOrderHeadData;

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

	
	@Autowired
	private SalesOrderApiService salesOrderApiService;
	
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
				e.printStackTrace();
			}
			
	}

	
	/**
	 * 	以下是 ISA 段的詳細解析與說明：
		ISA 段格式 (Interchange Control Header)
		ISA 段用於描述整個 EDI 文件交換的標頭信息，定義了交換的來源、目的、時間、控制信息以及分隔符的用法。
	 */
	public void ISA(){
		Isa isa =new Isa();
		
		
		
//		String isa ="ISA*00*          *00*          *ZZ*GTec123456789  *ZZ*PARTNER001     *20250108*1234*U*00401*000000001*0*P*>~";
	}

	@Override
	public void read850() {
		EDIInputFactory factory = EDIInputFactory.newFactory();
		List<SalesOrderHeadData> headList = new ArrayList();
		try {
			InputStream stream = new FileInputStream("D:\\Goldtek_test_PO.txt");

			EDIStreamReader reader = factory.createEDIStreamReader(stream);
			String current = "";
			int i = 0;
			SalesOrderHeadData head = new SalesOrderHeadData();
			String planDeliveryDate = "";//預交日
			BigDecimal totalAmount = BigDecimal.ZERO;
			int poItemCount = 0;
			BigDecimal totalCount = BigDecimal.ZERO;
			List<SalesOrderDetailData> list = new ArrayList();
			BigDecimal totalMoney =  BigDecimal.ZERO;
			
			SalesOrderDetailData detail = new SalesOrderDetailData();
			while (reader.hasNext()) {
				boolean isPoItem = false;
				BigDecimal count =  BigDecimal.ZERO;
				BigDecimal money =  BigDecimal.ZERO;
				switch (reader.next()) {
				case START_INTERCHANGE:
					String standard = reader.getStandard();
					String[] version = reader.getVersion();
					for (String s : version) {
						System.out.println("版本:" + s);
					}

					break;

				case START_SEGMENT:
					// Retrieve the segment name - e.g. "ISA" (X12), "UNB" (EDIFACT), or "STX"
					// (TRADACOMS)
					String segmentName = reader.getText();
					System.out.println("segmentName:" + segmentName+",i="+i);
					current = segmentName;
					if(segmentName.equals("PO1_1"))
						detail = new SalesOrderDetailData();
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
					System.out.println(key+":"+data);
					switch(key) {
						case "BEG_1"://單別00 表示原始訂單 01 表示取消訂單 02 表示修改訂單 05 表示替換訂單
							head.setSo_type_no("00");
							break;
						case "BEG_2":
							break;
						case "BEG_3"://採購訂單號碼
							head.setRemarks("NSY_"+data);
							break;
						case "BEG_5"://採購日期
							head.setOrder_date(data);
							break;	
						case "CUR_1":
							System.out.println("...");
							break;
						case "CUR_2"://匯率
							head.setTrans_currency(data);
							break;
						case "REF_2"://
							//內部供應商編號
							break;
						case "ITD_1"://指定付款條件類型的代碼。常見值：01 = 標準 05 = 日期基準折扣 14 = 延期付款
							break;
						case "ITD_2"://確定付款條件起算的基準日期 3 = 發票日期 15 = 收貨日期
							break;
						case "ITD_7"://全額支付應付款項的最後期限天數，例如 60 天
							break;
						case "DTM_1":// 指定日期或時間的類型代碼 002 送貨日期 預交日?
							break;	
						case "DTM_2":
							planDeliveryDate = data;
							break;	
						case "N3_1":
							head.setDelivery_address1(data);
							break;
						case "N4_1"://城市名稱
							break;
						case "N4_2"://州代號
							break;
						case "N4_3"://郵遞區號
							break;
						case "N4_4":
							head.setShipping_country_name(data);
							break;
						case "PO1_1":
							isPoItem = true;
							poItemCount++;
							detail.setSo_seq(data);
							break;
						case "PO1_2":
							count = new BigDecimal(data);
							totalCount.add(new BigDecimal(data));
							detail.setOrder_qty(new BigDecimal(data));
							break;
						case "PO1_3"://單位
							detail.setUnit(data);
							break;
						case "PO1_4"://單價
							detail.setPrice(new BigDecimal(data));
							break;
						case "PO1_5":
							break;
						case "PO1_6":
							break;
						case "PO1_7":
							System.out.println("*****************************");
							detail.setCustomer_item(data);
							list.add(detail);
							break;
						case "PID_1"://F 表示自由格式描述；S 表示結構化描述等。
							break;	
						case "PID_2"://???
							break;
						case "AMT_2"://
							totalAmount = totalAmount.add(new BigDecimal(data));
							System.out.println("totalAmount:"+totalAmount);
							break;
						case "CTT_1"://PO行數
							poItemCount++;
							break;
						case "CTT_2"://
							totalCount = totalCount.add(new BigDecimal(data));
							break;
						
						
					}

					break;
				}
			}
			//補齊剩餘必填欄位
			completeRequiredFields(head);
			head.setOrder_amount(totalAmount);//總價
			head.setTot_pqty(totalCount);
			head.setSales_order_detail_data(list);
			System.out.println(head.toString());
			headList.add(head);
			salesOrderApiService.create(headList);
			
			
			
			reader.close();
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EDIStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param head
	 */
	private void completeRequiredFields(SalesOrderHeadData head) {
		head.setSo_type_no("8787");
		head.setOm_site_id("00");//出貨廠別
		head.setTax_code(null);//課稅別
		head.setCommission_rate(BigDecimal.ZERO);//佣金比率
		head.setOrder_tax(null);//稅額 = 總金額 * 稅率
		head.setDoc_date("20240119");
		head.setTotal_gross_weight_kg(BigDecimal.ZERO);
		head.setTotal_cuft_size(BigDecimal.ZERO);
		head.setTotal_packing_qty(BigDecimal.ZERO);
		head.setVolume_unit("1");
		head.setTrade_condition("2");//要設什麼值?? 代表FOB?
		head.setDeposit_instalment("N");
		head.setIncome_postpone_days(new BigDecimal(60));//?
		head.setNo_credit_limit_control("N");//不控管信用額度
		head.setTax_code(null);//稅別碼
		head.setBody_multi_tax_rate("N");//單身多稅率
	}
	
	
	
	
	
}

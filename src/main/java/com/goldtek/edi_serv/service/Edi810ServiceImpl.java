package com.goldtek.edi_serv.service;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.goldtek.edi_serv.entity.Isa;

import io.xlate.edi.stream.EDIOutputFactory;
import io.xlate.edi.stream.EDIStreamConstants;
import io.xlate.edi.stream.EDIStreamWriter;

/**
 * 發票作業
 */
@Service
public class Edi810ServiceImpl implements Edi810Service{

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
	
}

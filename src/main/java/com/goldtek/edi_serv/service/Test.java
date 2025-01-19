package com.goldtek.edi_serv.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.xlate.edi.stream.EDIInputFactory;
import io.xlate.edi.stream.EDIOutputFactory;
import io.xlate.edi.stream.EDIStreamConstants;
import io.xlate.edi.stream.EDIStreamException;
import io.xlate.edi.stream.EDIStreamReader;
import io.xlate.edi.stream.EDIStreamWriter;

public class Test {
	/**
	 * 交換控制封套（ISA - IEA） └ 功能組（GS - GE） └ 交易集（ST - SE）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		test810();
//read810();
		
		
		
		test855();
		red855();
		
		
		
		
//		Isa isa = new Isa();
//
//		isa.setISA01("00");
//		isa.setISA02("          ");
//		isa.setISA03("00");
//		isa.setISA04("          ");
//		isa.setISA05("ZZ");
//		isa.setISA06("GTec123456789  ");
//		isa.setISA07("ZZ");
//		isa.setISA08("PARTNER001     ");
//		isa.setISA09("20250108");
//		isa.setISA10("1234");
//		isa.setISA11("U");
//		isa.setISA12("00401");
//		isa.setISA13("000000001");
//		isa.setISA14("0");
//		isa.setISA15("P");
//		isa.setISA16(">");
//
//		Gs gs = new Gs();
//		gs.setGS01("IN");
//		gs.setGS02("GTec");
//		gs.setGS03("PARTNER001");
//		gs.setGS04("20250108");
//		gs.setGS05("1234");
//		gs.setGS06("1");
//		gs.setGS07("X");
//		gs.setGS08("004010");
//
//		St st = new St();
//		st.setST01("810");
//		st.setST02("0001");
//		Big big = new Big();
//		big.setBIG01("20250108");
//		big.setBIG02("INV001");
//
//		Ref ref = new Ref();
//		ref.setREF01("IT");
//		ref.setREF02("NET30");
//		N1 n1 = new N1();
//		n1.setN101("BY");
//		n1.setN102("Buyer Name");
//
//		
//		It1 it1 =new It1();
//		it1.setIT101("0010");
//		it1.setIT102("10");
//		it1.setIT103("EA");
//		it1.setIT104("25.00");
//		it1.setIT105("");
//		it1.setIT106("VP");
//		it1.setIT107("WIDGET");
//		
//		
//		
//		Tds tds =new Tds();
//		tds.setTDS01("25000");
//		
//		//如果發票只涉及商品的單價和數量，並且沒有其他額外費用或折扣，則可以省略 SAC 段。
//		//當 TDS 段已經充分表達了所有費用和金額時，不需要 SAC 段。
//		Sac sac =new Sac();//非必要
//		
//		Ctt ctt =new Ctt();
//		ctt.setCTT01("1");
//		int i = 0;
//		System.out.println(isa.toString());
//		System.out.println(gs.toString());
//		System.out.println(st.toString());i++;
//		System.out.println(big.toString());i++;
//		System.out.println(ref.toString());i++;
//		System.out.println(n1.toString());i++;
//		System.out.println(it1.toString());i++;
//		System.out.println(tds.toString());i++;
//		System.out.println(ctt.toString());i++;
//		
//		//SE段 表示整個交易集包含 8 段（包括 ST 和 SE 段）。0001 與 ST 段中的控制號一致。
//		System.out.println("SE*8*0001~");
//		//GE段 1表示功能組包含 1 個交易集。 與 GS 段的功能組控制號一致
//		System.out.println("GE*1*1~");
//		//IEA段 1 表示整個 ISA 包含 1 個功能組。 000000001 與 ISA 段的控制號一致。
//		System.out.println("IEA*1*000000001~");
	}

	private static void red855() {
		// TODO Auto-generated method stub
		
	}

	private static void test855() {
		 try {
				// (1) Create an EDIOutputFactory
				EDIOutputFactory factory = EDIOutputFactory.newFactory();
				// Obtain Stream write the EDI document.
				OutputStream stream = new FileOutputStream("D:\\edi855-test.txt");
				int groupCount = 0;
				// (2) Optionally specify delimiters - here the given values are the same as default
				factory.setProperty(EDIStreamConstants.Delimiters.SEGMENT, '~');
				factory.setProperty(EDIStreamConstants.Delimiters.DATA_ELEMENT, '*');

				// Write each segment on a new line
				factory.setProperty(EDIOutputFactory.PRETTY_PRINT, true);

				// (3) Create an EDIStreamWriter. Any OutputStream may be used - here we are writing to the console
				EDIStreamWriter writer = factory.createEDIStreamWriter(stream);

				// (4) Start the interchange
				writer.startInterchange();
				int i=0;
				// (5) Write the three segments necessary for the interchange acknowledgement (ISA, TA1, IEA)
				writer.writeStartSegment("ISA")
				      .writeElement("00")
				      .writeElement("          ")
				      .writeElement("00")
				      .writeElement("          ")
				      .writeElement("01")
				      .writeElement("081174492TEST  ")
				      .writeElement("ZZ")
				      .writeElement("UVCBGXTWTPE0031")
				      .writeElement("250102")
				      .writeElement("0940")
				      .writeElement("U")
				      .writeElement("00401")
				      .writeElement("000000001")
				      .writeElement("0")
				      .writeElement("T")
				      .writeElement(">")
				      .writeEndSegment();
				i++;
				writer.writeStartSegment("GS")
				      .writeElement("IN")
				      .writeElement("GTec")
				      .writeElement("PARTNER001")
				      .writeElement("20250108")
				      .writeElement("1234")
				      .writeElement("1")
				      .writeElement("X")
				      .writeElement("004010")
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

	private static void read810() {
		EDIInputFactory factory = EDIInputFactory.newFactory();

		// Obtain Stream to the EDI document to read.
		try {
			InputStream stream = new FileInputStream("D:\\edi-test1.txt");

			EDIStreamReader reader = factory.createEDIStreamReader(stream);
			String current ="";
			int i =0;
			while (reader.hasNext()) {
			
			  switch (reader.next()) {
			  case START_INTERCHANGE:
			    /* Retrieve the standard - "X12", "EDIFACT", or "TRADACOMS" */
			    String standard = reader.getStandard();

			    /*
			     * Retrieve the version string array. An array is used to support
			     * the componentized version element used in the EDIFACT standard.
			     *
			     * e.g. [ "00501" ] (X12) or [ "UNOA", "3" ] (EDIFACT)
			     */
			    String[] version = reader.getVersion();
			    for(String s :version) {
			    	   System.out.println("版本:"+s);
			    }
			 
			    break;

			  case START_SEGMENT:
			    // Retrieve the segment name - e.g. "ISA" (X12), "UNB" (EDIFACT), or "STX" (TRADACOMS)
			    String segmentName = reader.getText();
			    System.out.println("segmentName:"+segmentName);
			    current = segmentName;
			    break;

			  case END_SEGMENT:
				  i= 0;
			    break;

			  case START_COMPOSITE:
			    break;

			  case END_COMPOSITE:
			    break;

			  case ELEMENT_DATA:
				i++;  
			    // Retrieve the value of the current element
			    String data = reader.getText();
			    System.out.println(current+"_"+i+":"+data);
			    break;
			  }
			}

			reader.close();
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EDIStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void test810() {

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
			EDIStreamWriter writer = factory.createEDIStreamWriter(stream);

			// (4) Start the interchange
			writer.startInterchange();
			int i=0;
			// (5) Write the three segments necessary for the interchange acknowledgement (ISA, TA1, IEA)
			writer.writeStartSegment("ISA")
			      .writeElement("00")//授權資訊類型
			      .writeElement("          ")//	授權資訊
			      .writeElement("00")//安全資訊類型
			      .writeElement("          ")//安全資訊
			      .writeElement("01")//發送者識別碼類型
			      .writeElement("081174492TEST  ")//發送者識別碼
			      .writeElement("ZZ")//接收者識別碼類型
			      .writeElement("UVCBGXTWTPE0031")//接收者識別碼
			      .writeElement("250102")//文件生成日期（YYMMDD）
			      .writeElement("0940")//文件生成時間（HHMM）
			      .writeElement("U")//控制標識
			      .writeElement("00401")//版本號
			      .writeElement("000000001")//控制號
			      .writeElement("0")//	回應請求標識
			      .writeElement("T")//用途標識
			      .writeElement(">")//分隔符識別碼
			      .writeEndSegment();
			i++;
			writer.writeStartSegment("GS")
			      .writeElement("IN")//功能組代碼
			      .writeElement("GTec")//發送者代碼
			      .writeElement("PARTNER001")//	接收者代碼
			      .writeElement("20250108")//功能組生成日期
			      .writeElement("1234")//功能組生成時間	
			      .writeElement("1")//	功能組控制號
			      .writeElement("X")//	負載標準代碼
			      .writeElement("004010")//	版本/釋放編號
			      .writeEndSegment();
			i++;
			writer.writeStartSegment("ST")
			      .writeElement("810")
			      .writeElement("INV001")
			      .writeEndSegment();
			i++;		
			
			writer.writeStartSegment("BIG")
		      .writeElement("20250108")//BIG01
		      .writeElement("INV001")//BIG02
		      //BIG03 採購單日期(非必要)
		      //BIG04 採購單單號(非必要)
		      .writeEndSegment();
			
			writer.writeStartSegment("REF")
		      .writeElement("IT")//IT (Terms)
		      .writeElement("NET30")//NET30 (付款條件：30天淨額)
		      .writeEndSegment();
			i++;	
			writer.writeStartSegment("N1")
		      .writeElement("BY")//BY (Buyer)
		      .writeElement("Buyer Name")
		      .writeEndSegment();
			i++;
			//區段: IT1 -基準線項目資料 (發票明細)
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

}

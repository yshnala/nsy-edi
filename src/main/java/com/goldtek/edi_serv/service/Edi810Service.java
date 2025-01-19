package com.goldtek.edi_serv.service;

public interface Edi810Service {
	void getInvoiceFromErp();
	void convertToUdfFile();
}



//ISA*00*          *00*          *ZZ*GTec123456789  *ZZ*PARTNER001     *20250108*1234*U*00401*000000001*0*P*>~
//GS*IN*GTec*PARTNER001*20250108*1234*1*X*004010~
//ST*810*0001~
//BIG*20250108*INV001~
//REF*IT*NET30~
//N1*BY*Buyer Name~
//IT1*0010*10*EA*25.00**VP*WIDGET~
//IT1*0020*5*EA*50.00**VP*GADGET~
//TDS*50000~
//SE*10*0001~
//GE*1*1~
//IEA*1*000000001~
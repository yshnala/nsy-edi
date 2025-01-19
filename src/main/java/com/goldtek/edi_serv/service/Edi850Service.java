package com.goldtek.edi_serv.service;

public interface Edi850Service {
	void getInvoiceFromErp();
	void convertToUdfFile();
	void read850();
}



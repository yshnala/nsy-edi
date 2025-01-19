package com.goldtek.edi_serv;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.goldtek.edi_serv.entity.PurchaseOrder;
import com.goldtek.edi_serv.service.EDI850Processor;
import com.goldtek.edi_serv.service.Edi810Service;
import com.goldtek.edi_serv.service.Edi850Service;

@Component
public class ScheduledTasks {
	@Autowired
	private Edi810Service edi810Service;
	@Autowired
	private Edi850Service edi850Service;

	private static final Logger log = LogManager.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 50000)
	public void run810Process() {
//		edi810Service.getInvoiceFromErp();
//		edi810Service.convertToUdfFile();
	}

	@Scheduled(fixedRate = 50000)
	public void run850Process() {
		log.info("run 850 process...");
		edi850Service.read850();
//		try {
//			EDI850Processor processor = new EDI850Processor();
//			processor.processEDI("D:\\Goldtek_test_PO.txt");
//			PurchaseOrder purchaseOrder = processor.getPurchaseOrder();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
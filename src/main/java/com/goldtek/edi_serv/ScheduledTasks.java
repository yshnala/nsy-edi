package com.goldtek.edi_serv;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.goldtek.edi_serv.entity.erp.SalesOrderHeadData;
import com.goldtek.edi_serv.service.Edi810Service;
import com.goldtek.edi_serv.service.Edi850Service;
import com.goldtek.edi_serv.service.Edi855Service;

@Component
public class ScheduledTasks {
	@Autowired
	private Edi810Service edi810Service;
	@Autowired
	private Edi850Service edi850Service;
	@Autowired
	private Edi855Service edi855Service;

	private static final Logger log = LogManager.getLogger(ScheduledTasks.class);

//	@Scheduled(fixedRate = 5000000)
//	public void run810Process() {
//		edi810Service.getInvoiceFromErp();
//		edi810Service.convertToUdfFile();
//	}

	/**
	 * 
	 * @title: 850客戶訂單 
	 * @author: alan_huang
	 * @since: 2025年1月22日 上午8:26:11
	 */
//	@Scheduled(fixedRate = 50000000)
	public void run850Process() {
		log.info("run 850 process...");
		edi850Service.read850();
	}
	
	/**
	 * 
	 * @title: 855客戶訂單回應
	 * @author: alan_huang
	 * @since: 2025年1月22日 下午8:26:47
	 */
	@Scheduled(fixedRate = 50000000)
	public void run855Process() {
		log.info("run 855 process...");
		List<SalesOrderHeadData> list = edi855Service.get855FromErp();
		edi855Service.convertToUdfFile(list);
		
	}

}
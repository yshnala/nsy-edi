package com.goldtek.edi_serv.service;

import java.util.List;

import com.goldtek.edi_serv.entity.erp.SalesOrderHeadData;

public interface Edi855Service {
	List<SalesOrderHeadData> get855FromErp();
	void convertToUdfFile(List<SalesOrderHeadData> list);
}

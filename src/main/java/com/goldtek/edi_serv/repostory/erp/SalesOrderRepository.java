package com.goldtek.edi_serv.repostory.erp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.goldtek.edi_serv.entity.erp.SalesOrderHeadData;
import com.goldtek.edi_serv.entity.erp.SalesOrderHeadDataId;

public interface SalesOrderRepository extends JpaRepository<SalesOrderHeadData,SalesOrderHeadDataId>{
	List<SalesOrderHeadData> findByCustomerNoEqualsAndConfirmCodeIsAndSyncStatusIs(String customerNo,String confirmCode,String syncStatus);

	
	@Modifying
	@Transactional
	@Query("UPDATE SalesOrderHeadData s SET s.syncStatus = '1' WHERE s.id.soTypeNo = :soTypeNo  and s.id.soNo = :soNo ")
	int updateSyncStatusTo1ById(@Param("soTypeNo") String soTypeNo, @Param("soNo") String soNo);

}

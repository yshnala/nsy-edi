package com.goldtek.edi_serv.repostory.erp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldtek.edi_serv.entity.erp.ExchangeRateDetail;
import com.goldtek.edi_serv.entity.erp.ExchangeRateDetailId;
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateDetail,ExchangeRateDetailId> {
	
	List<ExchangeRateDetail> findByIdCurrOrderByIdEffectiveDateDesc(String curr);

}

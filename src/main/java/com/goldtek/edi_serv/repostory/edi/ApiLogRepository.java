package com.goldtek.edi_serv.repostory.edi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldtek.edi_serv.entity.edi.ApiLog;
@Repository
public interface ApiLogRepository extends JpaRepository<ApiLog,Long> {
	

}

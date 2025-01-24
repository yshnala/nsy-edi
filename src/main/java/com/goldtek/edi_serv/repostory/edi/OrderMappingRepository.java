package com.goldtek.edi_serv.repostory.edi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldtek.edi_serv.entity.edi.OrderMapping;

public interface OrderMappingRepository  extends JpaRepository<OrderMapping,Long>{

}

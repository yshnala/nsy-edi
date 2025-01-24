package com.goldtek.edi_serv.entity.erp;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SalesOrderDetailDataId implements Serializable {
	
	@Column(name = "TD001")
	private String soTypeNo; // 單別
	@Column(name = "TD002")
	private String soNo; // 單號
	@Column(name = "TD003")
	private String soSeq; // 序號
	
	public SalesOrderDetailDataId() {
	}

	public SalesOrderDetailDataId(String soTypeNo, String soNo, String soSeq) {
		this.soTypeNo = soTypeNo;
		this.soNo = soNo;
		this.soSeq = soSeq;

	}



	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SalesOrderDetailDataId exchangeRateDetailId = (SalesOrderDetailDataId) o;
		return Objects.equals(soTypeNo,exchangeRateDetailId.soTypeNo)
				&& Objects.equals(soNo, exchangeRateDetailId.soNo)
				&& Objects.equals(soSeq, exchangeRateDetailId.soSeq)
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soTypeNo, soNo, soSeq);
	}

	@Override
	public String toString() {
		return "SalesOrderDetailDataId [soTypeNo=" + soTypeNo + ", soNo=" + soNo + ", soSeq=" + soSeq + "]";
	}

	public String getSoTypeNo() {
		return soTypeNo;
	}

	public void setSoTypeNo(String soTypeNo) {
		this.soTypeNo = soTypeNo;
	}

	public String getSoNo() {
		return soNo;
	}

	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}

	public String getSoSeq() {
		return soSeq;
	}

	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}

	

	
	
}
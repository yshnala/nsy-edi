package com.goldtek.edi_serv.entity.erp;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class SalesOrderHeadDataId implements Serializable {
	
	@Column(name = "TC001")
	private String soTypeNo; // 單別
	@Column(name = "TC002")
	private String soNo; // 單號
	
	@Transient
	private String docDate;
	
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

	
	
	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public SalesOrderHeadDataId() {
	}

	public SalesOrderHeadDataId(String soTypeNo, String soNo) {
		this.soTypeNo = soTypeNo;
		this.soNo = soNo;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SalesOrderHeadDataId exchangeRateDetailId = (SalesOrderHeadDataId) o;
		return Objects.equals(soTypeNo,exchangeRateDetailId.soTypeNo)
				&& Objects.equals(soNo, exchangeRateDetailId.soNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(soTypeNo, soNo);
	}

	@Override
	public String toString() {
		return "SalesOrderHeadDataId [soTypeNo=" + soTypeNo + ", soNo=" + soNo + "]";
	}

	
	
	
}
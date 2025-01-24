package com.goldtek.edi_serv.entity.erp;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExchangeRateDetailId implements Serializable {
	@Column(name = "MG001")
	private String curr; // 單別
	@Column(name = "MG002")
	private String effectiveDate; // 單號
	
	public ExchangeRateDetailId() {
	}

	public ExchangeRateDetailId(String curr, String effectiveDate) {
		this.curr = curr;
		this.effectiveDate = effectiveDate;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ExchangeRateDetailId exchangeRateDetailId = (ExchangeRateDetailId) o;
		return Objects.equals(curr,exchangeRateDetailId.curr)
				&& Objects.equals(effectiveDate, exchangeRateDetailId.effectiveDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(curr, effectiveDate);
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public String getEffective_date() {
		return effectiveDate;
	}

	public void setEffective_date(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return "ExchangeRateDetailId [curr=" + curr + ", effectiveDate=" + effectiveDate + "]";
	}

	
	
}
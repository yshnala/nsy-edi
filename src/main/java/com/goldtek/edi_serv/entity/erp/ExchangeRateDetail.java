package com.goldtek.edi_serv.entity.erp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "CMSMG")
public class ExchangeRateDetail {
	
	@EmbeddedId
    private ExchangeRateDetailId id; // 複合主鍵
	
	@Column(name="MG003")
	private String bank_buying_exch_rate;//銀行買進匯率
	
	@Column(name="MG004")
	private String bank_selling_exchange_rate;//銀行賣出匯率
	
	@Column(name="MG005")
	private String customs_buying_exchange_rate;//報關買進匯率
	
	@Column(name="MG006")
	private String customs_selling_exchange_rate;//報關賣出匯率
	
	@Column(name="MG012")
	private String insurance_exch_rate;//投保匯率

	public ExchangeRateDetailId getId() {
		return id;
	}

	public void setId(ExchangeRateDetailId id) {
		this.id = id;
	}

	public String getBank_buying_exch_rate() {
		return bank_buying_exch_rate;
	}

	public void setBank_buying_exch_rate(String bank_buying_exch_rate) {
		this.bank_buying_exch_rate = bank_buying_exch_rate;
	}

	public String getBank_selling_exchange_rate() {
		return bank_selling_exchange_rate;
	}

	public void setBank_selling_exchange_rate(String bank_selling_exchange_rate) {
		this.bank_selling_exchange_rate = bank_selling_exchange_rate;
	}

	public String getCustoms_buying_exchange_rate() {
		return customs_buying_exchange_rate;
	}

	public void setCustoms_buying_exchange_rate(String customs_buying_exchange_rate) {
		this.customs_buying_exchange_rate = customs_buying_exchange_rate;
	}

	public String getCustoms_selling_exchange_rate() {
		return customs_selling_exchange_rate;
	}

	public void setCustoms_selling_exchange_rate(String customs_selling_exchange_rate) {
		this.customs_selling_exchange_rate = customs_selling_exchange_rate;
	}

	public String getInsurance_exch_rate() {
		return insurance_exch_rate;
	}

	public void setInsurance_exch_rate(String insurance_exch_rate) {
		this.insurance_exch_rate = insurance_exch_rate;
	}

	
	
	
	
	
}

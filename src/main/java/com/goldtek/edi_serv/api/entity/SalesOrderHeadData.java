package com.goldtek.edi_serv.api.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesOrderHeadData {

	// 訂單單別
	// TABLE: COPTC.TC001
	private String so_type_no;

	// 訂單單號
	// TABLE: COPTC.TC002
	private String so_no;

	// 訂單日期
	// TABLE: COPTC.TC003
	private String order_date;

	// 客戶代號
	// TABLE: COPTC.TC004
	private String customer_no;

	// 部門代號
	// TABLE: COPTC.TC005
	private String department_no;

	// 業務人員
	// TABLE: COPTC.TC006
	private String salesman_no;

	// 出貨廠別
	// TABLE: COPTC.TC007
	private String om_site_id;

	// 交易幣別
	// TABLE: COPTC.TC008
	private String trans_currency;

	// 匯率
	// TABLE: COPTC.TC009
	private BigDecimal exchange_rate;

	// 送貨地址(一)
	// TABLE: COPTC.TC010
	private String delivery_address1;

	// 送貨地址(二)
	// TABLE: COPTC.TC011
	private String delivery_address2;

	// 客戶單號
	// TABLE: COPTC.TC012
	private String customer_doc_no;

	// 價格條件
	// TABLE: COPTC.TC013
	private String price_condition;

	// 付款條件
	// TABLE: COPTC.TC014
	private String payment_condition;

	// 備註
	// TABLE: COPTC.TC015
	private String remarks;

	// 課稅別
	// TABLE: COPTC.TC016
	private String taxed_code;

	// L/CNO.
	// TABLE: COPTC.TC017
	private String l_c_no;

	// 連絡人
	// TABLE: COPTC.TC018
	private String contact;

	// 運輸方式
	// TABLE: COPTC.TC019
	private String transport_mode_no;

	// 代理商
	// TABLE: COPTC.TC022
	private String agent;

	// 報關行
	// TABLE: COPTC.TC023
	private String broker;

	// 驗貨公司
	// TABLE: COPTC.TC024
	private String inspection_company;

	// 運輸公司
	// TABLE: COPTC.TC025
	private String transport_company_no;

	// 佣金比率
	// TABLE: COPTC.TC026
	private BigDecimal commission_rate;

	// 訂單金額
	// TABLE: COPTC.TC029
	private BigDecimal order_amount;

	// 訂單稅額
	// TABLE: COPTC.TC030
	private BigDecimal order_tax;

	// 總數量
	// TABLE: COPTC.TC031
	private BigDecimal tot_pqty;

	// CONSIGNEE
	// TABLE: COPTC.TC032
	private String consignee;

	// NOTIFY
	// TABLE: COPTC.TC033
	private String notify;

	// 嘜頭代號
	// TABLE: COPTC.TC034
	private String shipping_mark_no;

	// 目的地
	// TABLE: COPTC.TC035
	private String destination;

	// 往來銀行
	// TABLE: COPTC.TC036
	private String correspondent_bank_no;

	// INVOICE備註
	// TABLE: COPTC.TC037
	private String invoice_remark;

	// PACKING-LIST備註
	// TABLE: COPTC.TC038
	private String packing_list_remark;

	// 單據日期
	// TABLE: COPTC.TC039
	private String doc_date;

	// 營業稅率
	// TABLE: COPTC.TC041
	private BigDecimal tax_rate;

	// 付款條件代號
	// TABLE: COPTC.TC042
	private String payment_condition_no;

	// 總毛重(Kg)
	// TABLE: COPTC.TC043
	private BigDecimal total_gross_weight_kg;

	// 總材積(CUFT)
	// TABLE: COPTC.TC044
	private BigDecimal total_cuft_size;

	// 訂金比率
	// TABLE: COPTC.TC045
	private BigDecimal deposit_rate;

	// 總包裝數量
	// TABLE: COPTC.TC046
	private BigDecimal total_packing_qty;

	// 押匯銀行
	// TABLE: COPTC.TC047
	private String negotiating_bank;

	// 流程代號
	// TABLE: COPTC.TC049
	private String process_code;

	// 下游廠商
	// TABLE: COPTC.TC051
	private String downstream_supplier;

	// 客戶全名
	// TABLE: COPTC.TC053
	private String customer_name;

	// 正嘜
	// TABLE: COPTC.TC054
	private String mark;

	// 側嘜
	// TABLE: COPTC.TC055
	private String side_mark;

	// 材積單位
	// TABLE: COPTC.TC056
	private String volume_unit;

	// 正嘜文管代號
	// TABLE: COPTC.TC061
	private String front_mark_document_manage_system_id;

	// 側嘜文管代號
	// TABLE: COPTC.TC062
	private String side_mark_document_manage_system_id;

	// 發票地址(一)
	// TABLE: COPTC.TC063
	private String invoice_address1;

	// 發票地址(二)
	// TABLE: COPTC.TC064
	private String invoice_address2;

	// 送貨客戶全名
	// TABLE: COPTC.TC065
	private String delivery_customer;

	// TEL_NO
	// TABLE: COPTC.TC066
	private String tel_no;

	// FAX_NO
	// TABLE: COPTC.TC067
	private String fax_no;

	// 交易條件
	// TABLE: COPTC.TC068
	private String trade_condition;

	// 訂金分批
	// TABLE: COPTC.TC070
	private String deposit_instalment;

	// 客戶英文全名
	// TABLE: COPTC.TC071
	private String customer_name_en;

	// 收入遞延天數
	// TABLE: COPTC.TC073
	private BigDecimal income_postpone_days;

	// 不控管信用額度
	// TABLE: COPTC.TC077
	private String no_credit_limit_control;

	// 稅別碼
	// TABLE: COPTC.TC078
	private String tax_code;

	// 出口港
	// TABLE: COPTC.TC085
	private String export_port;

	// 經過港口
	// TABLE: COPTC.TC086
	private String transit_port;

	// 目的港口
	// TABLE: COPTC.TC087
	private String destination_port;

	// 最上游客戶
	// TABLE: COPTC.TC088
	private String most_upstream_customer_no;

	// 最上游交易幣別
	// TABLE: COPTC.TC089
	private String most_upstream_customer_trans_currency;

	// 最上游稅別碼
	// TABLE: COPTC.TC090
	private String most_upstream_tax_code;

	// 單身多稅率
	// TABLE: COPTC.TC091
	private String body_multi_tax_rate;

	// 來源
	// TABLE: COPTC.TC092
	private String source;

	// 送貨國家
	// TABLE: COPTC.TC093
	private String shipping_country_name;

	private List<SalesOrderDetailData> sales_order_detail_data;

	public String getSo_type_no() {
		return so_type_no;
	}

	public void setSo_type_no(String so_type_no) {
		this.so_type_no = so_type_no;
	}

	public String getSo_no() {
		return so_no;
	}

	public void setSo_no(String so_no) {
		this.so_no = so_no;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}

	public String getDepartment_no() {
		return department_no;
	}

	public void setDepartment_no(String department_no) {
		this.department_no = department_no;
	}

	public String getSalesman_no() {
		return salesman_no;
	}

	public void setSalesman_no(String salesman_no) {
		this.salesman_no = salesman_no;
	}

	public String getOm_site_id() {
		return om_site_id;
	}

	public void setOm_site_id(String om_site_id) {
		this.om_site_id = om_site_id;
	}

	public String getTrans_currency() {
		return trans_currency;
	}

	public void setTrans_currency(String trans_currency) {
		this.trans_currency = trans_currency;
	}

	public BigDecimal getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(BigDecimal exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public String getDelivery_address1() {
		return delivery_address1;
	}

	public void setDelivery_address1(String delivery_address1) {
		this.delivery_address1 = delivery_address1;
	}

	public String getDelivery_address2() {
		return delivery_address2;
	}

	public void setDelivery_address2(String delivery_address2) {
		this.delivery_address2 = delivery_address2;
	}

	public String getCustomer_doc_no() {
		return customer_doc_no;
	}

	public void setCustomer_doc_no(String customer_doc_no) {
		this.customer_doc_no = customer_doc_no;
	}

	public String getPrice_condition() {
		return price_condition;
	}

	public void setPrice_condition(String price_condition) {
		this.price_condition = price_condition;
	}

	public String getPayment_condition() {
		return payment_condition;
	}

	public void setPayment_condition(String payment_condition) {
		this.payment_condition = payment_condition;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTaxed_code() {
		return taxed_code;
	}

	public void setTaxed_code(String taxed_code) {
		this.taxed_code = taxed_code;
	}

	public String getL_c_no() {
		return l_c_no;
	}

	public void setL_c_no(String l_c_no) {
		this.l_c_no = l_c_no;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTransport_mode_no() {
		return transport_mode_no;
	}

	public void setTransport_mode_no(String transport_mode_no) {
		this.transport_mode_no = transport_mode_no;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getInspection_company() {
		return inspection_company;
	}

	public void setInspection_company(String inspection_company) {
		this.inspection_company = inspection_company;
	}

	public String getTransport_company_no() {
		return transport_company_no;
	}

	public void setTransport_company_no(String transport_company_no) {
		this.transport_company_no = transport_company_no;
	}

	public BigDecimal getCommission_rate() {
		return commission_rate;
	}

	public void setCommission_rate(BigDecimal commission_rate) {
		this.commission_rate = commission_rate;
	}

	public BigDecimal getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(BigDecimal order_amount) {
		this.order_amount = order_amount;
	}

	public BigDecimal getOrder_tax() {
		return order_tax;
	}

	public void setOrder_tax(BigDecimal order_tax) {
		this.order_tax = order_tax;
	}

	public BigDecimal getTot_pqty() {
		return tot_pqty;
	}

	public void setTot_pqty(BigDecimal tot_pqty) {
		this.tot_pqty = tot_pqty;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getShipping_mark_no() {
		return shipping_mark_no;
	}

	public void setShipping_mark_no(String shipping_mark_no) {
		this.shipping_mark_no = shipping_mark_no;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCorrespondent_bank_no() {
		return correspondent_bank_no;
	}

	public void setCorrespondent_bank_no(String correspondent_bank_no) {
		this.correspondent_bank_no = correspondent_bank_no;
	}

	public String getInvoice_remark() {
		return invoice_remark;
	}

	public void setInvoice_remark(String invoice_remark) {
		this.invoice_remark = invoice_remark;
	}

	public String getPacking_list_remark() {
		return packing_list_remark;
	}

	public void setPacking_list_remark(String packing_list_remark) {
		this.packing_list_remark = packing_list_remark;
	}

	public String getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

	public BigDecimal getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(BigDecimal tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getPayment_condition_no() {
		return payment_condition_no;
	}

	public void setPayment_condition_no(String payment_condition_no) {
		this.payment_condition_no = payment_condition_no;
	}

	public BigDecimal getTotal_gross_weight_kg() {
		return total_gross_weight_kg;
	}

	public void setTotal_gross_weight_kg(BigDecimal total_gross_weight_kg) {
		this.total_gross_weight_kg = total_gross_weight_kg;
	}

	public BigDecimal getTotal_cuft_size() {
		return total_cuft_size;
	}

	public void setTotal_cuft_size(BigDecimal total_cuft_size) {
		this.total_cuft_size = total_cuft_size;
	}

	public BigDecimal getDeposit_rate() {
		return deposit_rate;
	}

	public void setDeposit_rate(BigDecimal deposit_rate) {
		this.deposit_rate = deposit_rate;
	}

	public BigDecimal getTotal_packing_qty() {
		return total_packing_qty;
	}

	public void setTotal_packing_qty(BigDecimal total_packing_qty) {
		this.total_packing_qty = total_packing_qty;
	}

	public String getNegotiating_bank() {
		return negotiating_bank;
	}

	public void setNegotiating_bank(String negotiating_bank) {
		this.negotiating_bank = negotiating_bank;
	}

	public String getProcess_code() {
		return process_code;
	}

	public void setProcess_code(String process_code) {
		this.process_code = process_code;
	}

	public String getDownstream_supplier() {
		return downstream_supplier;
	}

	public void setDownstream_supplier(String downstream_supplier) {
		this.downstream_supplier = downstream_supplier;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getSide_mark() {
		return side_mark;
	}

	public void setSide_mark(String side_mark) {
		this.side_mark = side_mark;
	}

	public String getVolume_unit() {
		return volume_unit;
	}

	public void setVolume_unit(String volume_unit) {
		this.volume_unit = volume_unit;
	}

	public String getFront_mark_document_manage_system_id() {
		return front_mark_document_manage_system_id;
	}

	public void setFront_mark_document_manage_system_id(String front_mark_document_manage_system_id) {
		this.front_mark_document_manage_system_id = front_mark_document_manage_system_id;
	}

	public String getSide_mark_document_manage_system_id() {
		return side_mark_document_manage_system_id;
	}

	public void setSide_mark_document_manage_system_id(String side_mark_document_manage_system_id) {
		this.side_mark_document_manage_system_id = side_mark_document_manage_system_id;
	}

	public String getInvoice_address1() {
		return invoice_address1;
	}

	public void setInvoice_address1(String invoice_address1) {
		this.invoice_address1 = invoice_address1;
	}

	public String getInvoice_address2() {
		return invoice_address2;
	}

	public void setInvoice_address2(String invoice_address2) {
		this.invoice_address2 = invoice_address2;
	}

	public String getDelivery_customer() {
		return delivery_customer;
	}

	public void setDelivery_customer(String delivery_customer) {
		this.delivery_customer = delivery_customer;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getFax_no() {
		return fax_no;
	}

	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}

	public String getTrade_condition() {
		return trade_condition;
	}

	public void setTrade_condition(String trade_condition) {
		this.trade_condition = trade_condition;
	}

	public String getDeposit_instalment() {
		return deposit_instalment;
	}

	public void setDeposit_instalment(String deposit_instalment) {
		this.deposit_instalment = deposit_instalment;
	}

	public String getCustomer_name_en() {
		return customer_name_en;
	}

	public void setCustomer_name_en(String customer_name_en) {
		this.customer_name_en = customer_name_en;
	}

	public BigDecimal getIncome_postpone_days() {
		return income_postpone_days;
	}

	public void setIncome_postpone_days(BigDecimal income_postpone_days) {
		this.income_postpone_days = income_postpone_days;
	}

	public String getNo_credit_limit_control() {
		return no_credit_limit_control;
	}

	public void setNo_credit_limit_control(String no_credit_limit_control) {
		this.no_credit_limit_control = no_credit_limit_control;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getExport_port() {
		return export_port;
	}

	public void setExport_port(String export_port) {
		this.export_port = export_port;
	}

	public String getTransit_port() {
		return transit_port;
	}

	public void setTransit_port(String transit_port) {
		this.transit_port = transit_port;
	}

	public String getDestination_port() {
		return destination_port;
	}

	public void setDestination_port(String destination_port) {
		this.destination_port = destination_port;
	}

	public String getMost_upstream_customer_no() {
		return most_upstream_customer_no;
	}

	public void setMost_upstream_customer_no(String most_upstream_customer_no) {
		this.most_upstream_customer_no = most_upstream_customer_no;
	}

	public String getMost_upstream_customer_trans_currency() {
		return most_upstream_customer_trans_currency;
	}

	public void setMost_upstream_customer_trans_currency(String most_upstream_customer_trans_currency) {
		this.most_upstream_customer_trans_currency = most_upstream_customer_trans_currency;
	}

	public String getMost_upstream_tax_code() {
		return most_upstream_tax_code;
	}

	public void setMost_upstream_tax_code(String most_upstream_tax_code) {
		this.most_upstream_tax_code = most_upstream_tax_code;
	}

	public String getBody_multi_tax_rate() {
		return body_multi_tax_rate;
	}

	public void setBody_multi_tax_rate(String body_multi_tax_rate) {
		this.body_multi_tax_rate = body_multi_tax_rate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getShipping_country_name() {
		return shipping_country_name;
	}

	public void setShipping_country_name(String shipping_country_name) {
		this.shipping_country_name = shipping_country_name;
	}

	
	
	public List<SalesOrderDetailData> getSales_order_detail_data() {
		return sales_order_detail_data;
	}

	public void setSales_order_detail_data(List<SalesOrderDetailData> sales_order_detail_data) {
		this.sales_order_detail_data = sales_order_detail_data;
	}

	@Override
	public String toString() {
		return "SalesOrderHeadData [so_type_no=" + so_type_no + ", so_no=" + so_no + ", order_date=" + order_date
				+ ", customer_no=" + customer_no + ", department_no=" + department_no + ", salesman_no=" + salesman_no
				+ ", om_site_id=" + om_site_id + ", trans_currency=" + trans_currency + ", exchange_rate="
				+ exchange_rate + ", delivery_address1=" + delivery_address1 + ", delivery_address2="
				+ delivery_address2 + ", customer_doc_no=" + customer_doc_no + ", price_condition=" + price_condition
				+ ", payment_condition=" + payment_condition + ", remarks=" + remarks + ", taxed_code=" + taxed_code
				+ ", l_c_no=" + l_c_no + ", contact=" + contact + ", transport_mode_no=" + transport_mode_no
				+ ", agent=" + agent + ", broker=" + broker + ", inspection_company=" + inspection_company
				+ ", transport_company_no=" + transport_company_no + ", commission_rate=" + commission_rate
				+ ", order_amount=" + order_amount + ", order_tax=" + order_tax + ", tot_pqty=" + tot_pqty
				+ ", consignee=" + consignee + ", notify=" + notify + ", shipping_mark_no=" + shipping_mark_no
				+ ", destination=" + destination + ", correspondent_bank_no=" + correspondent_bank_no
				+ ", invoice_remark=" + invoice_remark + ", packing_list_remark=" + packing_list_remark + ", doc_date="
				+ doc_date + ", tax_rate=" + tax_rate + ", payment_condition_no=" + payment_condition_no
				+ ", total_gross_weight_kg=" + total_gross_weight_kg + ", total_cuft_size=" + total_cuft_size
				+ ", deposit_rate=" + deposit_rate + ", total_packing_qty=" + total_packing_qty + ", negotiating_bank="
				+ negotiating_bank + ", process_code=" + process_code + ", downstream_supplier=" + downstream_supplier
				+ ", customer_name=" + customer_name + ", mark=" + mark + ", side_mark=" + side_mark + ", volume_unit="
				+ volume_unit + ", front_mark_document_manage_system_id=" + front_mark_document_manage_system_id
				+ ", side_mark_document_manage_system_id=" + side_mark_document_manage_system_id + ", invoice_address1="
				+ invoice_address1 + ", invoice_address2=" + invoice_address2 + ", delivery_customer="
				+ delivery_customer + ", tel_no=" + tel_no + ", fax_no=" + fax_no + ", trade_condition="
				+ trade_condition + ", deposit_instalment=" + deposit_instalment + ", customer_name_en="
				+ customer_name_en + ", income_postpone_days=" + income_postpone_days + ", no_credit_limit_control="
				+ no_credit_limit_control + ", tax_code=" + tax_code + ", export_port=" + export_port
				+ ", transit_port=" + transit_port + ", destination_port=" + destination_port
				+ ", most_upstream_customer_no=" + most_upstream_customer_no
				+ ", most_upstream_customer_trans_currency=" + most_upstream_customer_trans_currency
				+ ", most_upstream_tax_code=" + most_upstream_tax_code + ", body_multi_tax_rate=" + body_multi_tax_rate
				+ ", source=" + source + ", shipping_country_name=" + shipping_country_name
				+ ", sales_order_detail_data=" + sales_order_detail_data + "]";
	}
	
	

}
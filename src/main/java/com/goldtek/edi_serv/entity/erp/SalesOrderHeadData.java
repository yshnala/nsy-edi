package com.goldtek.edi_serv.entity.erp;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COPTC")
public class SalesOrderHeadData {
	@EmbeddedId
    private SalesOrderHeadDataId id; // 複合主鍵
	

    @OneToMany(fetch = FetchType.EAGER  , cascade = CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name = "TD001", referencedColumnName = "TC001"),
        @JoinColumn(name = "TD002", referencedColumnName = "TC002")
    })
    private List<SalesOrderDetailData> details; // 明細資料
	
	@Column(name="TC003")
	private String orderDate; // 訂單日期

	@Column(name="TC004")
	private String customerNo; // 客戶代號

	@Column(name="TC005")
	private String departmentNo; // 部門代號

	@Column(name="TC006")
	private String salesmanNo; // 業務人員

	@Column(name="TC007")
	private String omSiteId; // 出貨廠別

	@Column(name="TC008")
	private String transCurrency; // 交易幣別

	@Column(name="TC009")
	private BigDecimal exchangeRate; // 匯率

	@Column(name="TC010")
	private String deliveryAddress1; // 送貨地址(一)

	@Column(name="TC011")
	private String deliveryAddress2; // 送貨地址(二)

	@Column(name="TC012")
	private String customerDocNo; // 客戶單號

	@Column(name="TC013")
	private String priceCondition; // 價格條件

	@Column(name="TC014")
	private String paymentCondition; // 付款條件

	@Column(name="TC015")
	private String remarks; // 備註

	@Column(name="TC016")
	private String taxedCode; // 課稅別

	@Column(name="TC017")
	private String lcNo; // L/CNO.

	@Column(name="TC018")
	private String contact; // 連絡人

	@Column(name="TC019")
	private String transportModeNo; // 運輸方式

	@Column(name="TC022")
	private String agent; // 代理商

	@Column(name="TC023")
	private String broker; // 報關行

	@Column(name="TC024")
	private String inspectionCompany; // 驗貨公司

	@Column(name="TC025")
	private String transportCompanyNo; // 運輸公司

	@Column(name="TC026")
	private BigDecimal commissionRate; // 佣金比率

	@Column(name="TC027")
	private String confirmCode;// 確認碼
	
	
	@Column(name="TC029")
	private BigDecimal orderAmount; // 訂單金額

	@Column(name="TC030")
	private BigDecimal orderTax; // 訂單稅額

	@Column(name="TC031")
	private BigDecimal totPqty; // 總數量

	@Column(name="TC032")
	private String consignee; // CONSIGNEE

	@Column(name="TC033")
	private String notify; // NOTIFY

	@Column(name="TC034")
	private String shippingMarkNo; // 嘜頭代號

	@Column(name="TC035")
	private String destination; // 目的地

	@Column(name="TC036")
	private String correspondentBankNo; // 往來銀行

	@Column(name="TC037")
	private String invoiceRemark; // INVOICE備註

	@Column(name="TC038")
	private String packingListRemark; // PACKING-LIST備註

	@Column(name="TC039")
	private String docDate; // 單據日期

	@Column(name="TC041")
	private BigDecimal taxRate; // 營業稅率

	@Column(name="TC042")
	private String paymentConditionNo; // 付款條件代號

	@Column(name="TC043")
	private BigDecimal totalGrossWeightKg; // 總毛重(Kg)

	@Column(name="TC044")
	private BigDecimal totalCuftSize; // 總材積(CUFT)

	@Column(name="TC045")
	private BigDecimal depositRate; // 訂金比率

	@Column(name="TC046")
	private BigDecimal totalPackingQty; // 總包裝數量

	@Column(name="TC047")
	private String negotiatingBank; // 押匯銀行

	@Column(name="TC049")
	private String processCode; // 流程代號

	@Column(name="TC051")
	private String downstreamSupplier; // 下游廠商

	@Column(name="TC053")
	private String customerName; // 客戶全名

	@Column(name="TC054")
	private String mark; // 正嘜

	@Column(name="TC055")
	private String sideMark; // 側嘜

	@Column(name="TC056")
	private String volumeUnit; // 材積單位

	@Column(name="TC061")
	private String frontMarkDocumentManageSystemId; // 正嘜文管代號

	@Column(name="TC062")
	private String sideMarkDocumentManageSystemId; // 側嘜文管代號

	@Column(name="TC063")
	private String invoiceAddress1; // 發票地址(一)

	@Column(name="TC064")
	private String invoiceAddress2; // 發票地址(二)

	@Column(name="TC065")
	private String deliveryCustomer; // 送貨客戶全名

	@Column(name="TC066")
	private String telNo; // TEL_NO

	@Column(name="TC067")
	private String faxNo; // FAX_NO

	@Column(name="TC068")
	private String tradeCondition; // 交易條件

	@Column(name="TC070")
	private String depositInstalment; // 訂金分批

	@Column(name="TC071")
	private String customerNameEn; // 客戶英文全名

	@Column(name="TC073")
	private BigDecimal incomePostponeDays; // 收入遞延天數

	@Column(name="TC077")
	private String noCreditLimitControl; // 不控管信用額度

	@Column(name="TC078")
	private String taxCode; // 稅別碼

	@Column(name="TC085")
	private String exportPort; // 出口港

	@Column(name="TC086")
	private String transitPort; // 經過港口

	@Column(name="TC087")
	private String destinationPort; // 目的港口

	@Column(name="TC088")
	private String mostUpstreamCustomerNo; // 最上游客戶

	@Column(name="TC089")
	private String mostUpstreamCustomerTransCurrency; // 最上游交易幣別

	@Column(name="TC090")
	private String mostUpstreamTaxCode; // 最上游稅別碼

	@Column(name="TC091")
	private String bodyMultiTaxRate; // 單身多稅率

	@Column(name="TC092")
	private String source; // 來源

	@Column(name="TC093")
	private String shippingCountryName; // 送貨國家
	
	@Column(name="UDF01")
	private String syncStatus; // 拋轉狀態
	

	public SalesOrderHeadDataId getId() {
		return id;
	}

	public void setId(SalesOrderHeadDataId id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getSalesmanNo() {
		return salesmanNo;
	}

	public void setSalesmanNo(String salesmanNo) {
		this.salesmanNo = salesmanNo;
	}

	public String getOmSiteId() {
		return omSiteId;
	}

	public void setOmSiteId(String omSiteId) {
		this.omSiteId = omSiteId;
	}

	public String getTransCurrency() {
		return transCurrency;
	}

	public void setTransCurrency(String transCurrency) {
		this.transCurrency = transCurrency;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getDeliveryAddress1() {
		return deliveryAddress1;
	}

	public void setDeliveryAddress1(String deliveryAddress1) {
		this.deliveryAddress1 = deliveryAddress1;
	}

	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}

	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}

	public String getCustomerDocNo() {
		return customerDocNo;
	}

	public void setCustomerDocNo(String customerDocNo) {
		this.customerDocNo = customerDocNo;
	}

	public String getPriceCondition() {
		return priceCondition;
	}

	public void setPriceCondition(String priceCondition) {
		this.priceCondition = priceCondition;
	}

	public String getPaymentCondition() {
		return paymentCondition;
	}

	public void setPaymentCondition(String paymentCondition) {
		this.paymentCondition = paymentCondition;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTaxedCode() {
		return taxedCode;
	}

	public void setTaxedCode(String taxedCode) {
		this.taxedCode = taxedCode;
	}

	public String getLcNo() {
		return lcNo;
	}

	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTransportModeNo() {
		return transportModeNo;
	}

	public void setTransportModeNo(String transportModeNo) {
		this.transportModeNo = transportModeNo;
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

	public String getInspectionCompany() {
		return inspectionCompany;
	}

	public void setInspectionCompany(String inspectionCompany) {
		this.inspectionCompany = inspectionCompany;
	}

	public String getTransportCompanyNo() {
		return transportCompanyNo;
	}

	public void setTransportCompanyNo(String transportCompanyNo) {
		this.transportCompanyNo = transportCompanyNo;
	}

	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(BigDecimal orderTax) {
		this.orderTax = orderTax;
	}

	public BigDecimal getTotPqty() {
		return totPqty;
	}

	public void setTotPqty(BigDecimal totPqty) {
		this.totPqty = totPqty;
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

	public String getShippingMarkNo() {
		return shippingMarkNo;
	}

	public void setShippingMarkNo(String shippingMarkNo) {
		this.shippingMarkNo = shippingMarkNo;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCorrespondentBankNo() {
		return correspondentBankNo;
	}

	public void setCorrespondentBankNo(String correspondentBankNo) {
		this.correspondentBankNo = correspondentBankNo;
	}

	public String getInvoiceRemark() {
		return invoiceRemark;
	}

	public void setInvoiceRemark(String invoiceRemark) {
		this.invoiceRemark = invoiceRemark;
	}

	public String getPackingListRemark() {
		return packingListRemark;
	}

	public void setPackingListRemark(String packingListRemark) {
		this.packingListRemark = packingListRemark;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public String getPaymentConditionNo() {
		return paymentConditionNo;
	}

	public void setPaymentConditionNo(String paymentConditionNo) {
		this.paymentConditionNo = paymentConditionNo;
	}

	public BigDecimal getTotalGrossWeightKg() {
		return totalGrossWeightKg;
	}

	public void setTotalGrossWeightKg(BigDecimal totalGrossWeightKg) {
		this.totalGrossWeightKg = totalGrossWeightKg;
	}

	public BigDecimal getTotalCuftSize() {
		return totalCuftSize;
	}

	public void setTotalCuftSize(BigDecimal totalCuftSize) {
		this.totalCuftSize = totalCuftSize;
	}

	public BigDecimal getDepositRate() {
		return depositRate;
	}

	public void setDepositRate(BigDecimal depositRate) {
		this.depositRate = depositRate;
	}

	public BigDecimal getTotalPackingQty() {
		return totalPackingQty;
	}

	public void setTotalPackingQty(BigDecimal totalPackingQty) {
		this.totalPackingQty = totalPackingQty;
	}

	public String getNegotiatingBank() {
		return negotiatingBank;
	}

	public void setNegotiatingBank(String negotiatingBank) {
		this.negotiatingBank = negotiatingBank;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getDownstreamSupplier() {
		return downstreamSupplier;
	}

	public void setDownstreamSupplier(String downstreamSupplier) {
		this.downstreamSupplier = downstreamSupplier;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getSideMark() {
		return sideMark;
	}

	public void setSideMark(String sideMark) {
		this.sideMark = sideMark;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	public String getFrontMarkDocumentManageSystemId() {
		return frontMarkDocumentManageSystemId;
	}

	public void setFrontMarkDocumentManageSystemId(String frontMarkDocumentManageSystemId) {
		this.frontMarkDocumentManageSystemId = frontMarkDocumentManageSystemId;
	}

	public String getSideMarkDocumentManageSystemId() {
		return sideMarkDocumentManageSystemId;
	}

	public void setSideMarkDocumentManageSystemId(String sideMarkDocumentManageSystemId) {
		this.sideMarkDocumentManageSystemId = sideMarkDocumentManageSystemId;
	}

	public String getInvoiceAddress1() {
		return invoiceAddress1;
	}

	public void setInvoiceAddress1(String invoiceAddress1) {
		this.invoiceAddress1 = invoiceAddress1;
	}

	public String getInvoiceAddress2() {
		return invoiceAddress2;
	}

	public void setInvoiceAddress2(String invoiceAddress2) {
		this.invoiceAddress2 = invoiceAddress2;
	}

	public String getDeliveryCustomer() {
		return deliveryCustomer;
	}

	public void setDeliveryCustomer(String deliveryCustomer) {
		this.deliveryCustomer = deliveryCustomer;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getTradeCondition() {
		return tradeCondition;
	}

	public void setTradeCondition(String tradeCondition) {
		this.tradeCondition = tradeCondition;
	}

	public String getDepositInstalment() {
		return depositInstalment;
	}

	public void setDepositInstalment(String depositInstalment) {
		this.depositInstalment = depositInstalment;
	}

	public String getCustomerNameEn() {
		return customerNameEn;
	}

	public void setCustomerNameEn(String customerNameEn) {
		this.customerNameEn = customerNameEn;
	}

	public BigDecimal getIncomePostponeDays() {
		return incomePostponeDays;
	}

	public void setIncomePostponeDays(BigDecimal incomePostponeDays) {
		this.incomePostponeDays = incomePostponeDays;
	}

	public String getNoCreditLimitControl() {
		return noCreditLimitControl;
	}

	public void setNoCreditLimitControl(String noCreditLimitControl) {
		this.noCreditLimitControl = noCreditLimitControl;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getExportPort() {
		return exportPort;
	}

	public void setExportPort(String exportPort) {
		this.exportPort = exportPort;
	}

	public String getTransitPort() {
		return transitPort;
	}

	public void setTransitPort(String transitPort) {
		this.transitPort = transitPort;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getMostUpstreamCustomerNo() {
		return mostUpstreamCustomerNo;
	}

	public void setMostUpstreamCustomerNo(String mostUpstreamCustomerNo) {
		this.mostUpstreamCustomerNo = mostUpstreamCustomerNo;
	}

	public String getMostUpstreamCustomerTransCurrency() {
		return mostUpstreamCustomerTransCurrency;
	}

	public void setMostUpstreamCustomerTransCurrency(String mostUpstreamCustomerTransCurrency) {
		this.mostUpstreamCustomerTransCurrency = mostUpstreamCustomerTransCurrency;
	}

	public String getMostUpstreamTaxCode() {
		return mostUpstreamTaxCode;
	}

	public void setMostUpstreamTaxCode(String mostUpstreamTaxCode) {
		this.mostUpstreamTaxCode = mostUpstreamTaxCode;
	}

	public String getBodyMultiTaxRate() {
		return bodyMultiTaxRate;
	}

	public void setBodyMultiTaxRate(String bodyMultiTaxRate) {
		this.bodyMultiTaxRate = bodyMultiTaxRate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getShippingCountryName() {
		return shippingCountryName;
	}

	public void setShippingCountryName(String shippingCountryName) {
		this.shippingCountryName = shippingCountryName;
	}

	public String getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	public List<SalesOrderDetailData> getDetails() {
		return details;
	}

	public void setDetails(List<SalesOrderDetailData> details) {
		this.details = details;
	}
	
	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	@Override
	public String toString() {
		return "SalesOrderHeadData [id=" + id + ", details=" + details + ", orderDate=" + orderDate + ", customerNo="
				+ customerNo + ", departmentNo=" + departmentNo + ", salesmanNo=" + salesmanNo + ", omSiteId="
				+ omSiteId + ", transCurrency=" + transCurrency + ", exchangeRate=" + exchangeRate
				+ ", deliveryAddress1=" + deliveryAddress1 + ", deliveryAddress2=" + deliveryAddress2
				+ ", customerDocNo=" + customerDocNo + ", priceCondition=" + priceCondition + ", paymentCondition="
				+ paymentCondition + ", remarks=" + remarks + ", taxedCode=" + taxedCode + ", lcNo=" + lcNo
				+ ", contact=" + contact + ", transportModeNo=" + transportModeNo + ", agent=" + agent + ", broker="
				+ broker + ", inspectionCompany=" + inspectionCompany + ", transportCompanyNo=" + transportCompanyNo
				+ ", commissionRate=" + commissionRate + ", confirmCode=" + confirmCode + ", orderAmount=" + orderAmount
				+ ", orderTax=" + orderTax + ", totPqty=" + totPqty + ", consignee=" + consignee + ", notify=" + notify
				+ ", shippingMarkNo=" + shippingMarkNo + ", destination=" + destination + ", correspondentBankNo="
				+ correspondentBankNo + ", invoiceRemark=" + invoiceRemark + ", packingListRemark=" + packingListRemark
				+ ", docDate=" + docDate + ", taxRate=" + taxRate + ", paymentConditionNo=" + paymentConditionNo
				+ ", totalGrossWeightKg=" + totalGrossWeightKg + ", totalCuftSize=" + totalCuftSize + ", depositRate="
				+ depositRate + ", totalPackingQty=" + totalPackingQty + ", negotiatingBank=" + negotiatingBank
				+ ", processCode=" + processCode + ", downstreamSupplier=" + downstreamSupplier + ", customerName="
				+ customerName + ", mark=" + mark + ", sideMark=" + sideMark + ", volumeUnit=" + volumeUnit
				+ ", frontMarkDocumentManageSystemId=" + frontMarkDocumentManageSystemId
				+ ", sideMarkDocumentManageSystemId=" + sideMarkDocumentManageSystemId + ", invoiceAddress1="
				+ invoiceAddress1 + ", invoiceAddress2=" + invoiceAddress2 + ", deliveryCustomer=" + deliveryCustomer
				+ ", telNo=" + telNo + ", faxNo=" + faxNo + ", tradeCondition=" + tradeCondition
				+ ", depositInstalment=" + depositInstalment + ", customerNameEn=" + customerNameEn
				+ ", incomePostponeDays=" + incomePostponeDays + ", noCreditLimitControl=" + noCreditLimitControl
				+ ", taxCode=" + taxCode + ", exportPort=" + exportPort + ", transitPort=" + transitPort
				+ ", destinationPort=" + destinationPort + ", mostUpstreamCustomerNo=" + mostUpstreamCustomerNo
				+ ", mostUpstreamCustomerTransCurrency=" + mostUpstreamCustomerTransCurrency + ", mostUpstreamTaxCode="
				+ mostUpstreamTaxCode + ", bodyMultiTaxRate=" + bodyMultiTaxRate + ", source=" + source
				+ ", shippingCountryName=" + shippingCountryName + ", syncStatus=" + syncStatus + "]";
	}




	    

}

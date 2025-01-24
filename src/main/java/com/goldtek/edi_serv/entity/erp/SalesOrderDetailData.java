package com.goldtek.edi_serv.entity.erp;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "COPTD")
public class SalesOrderDetailData {
	@EmbeddedId
    private SalesOrderDetailDataId id; // 複合主鍵
	
	@Column(name="TD004")
	private String itemNo; // 品號 Item No.

	@Column(name="TD005")
	private String itemName; // 品名 Item Name

	@Column(name="TD006")
	private String itemSpec; // 規格 Spec.

	@Column(name="TD007")
	private String warehouseNo; // 庫別 Store

	@Column(name="TD008")
	private BigDecimal orderQty; // 訂單數量 Order Qty

	@Column(name="TD010")
	private String unit; // 單位 Unit

	@Column(name="TD011")
	private BigDecimal price; // 單價 Unit Price

	@Column(name="TD012")
	private BigDecimal amount; // 金額 Amount

	@Column(name="TD013")
	private String planDeliveryDate; // 預交日 Plan Delivery Date

	@Column(name="TD014")
	private String customerItem; // 客戶品號 Customer Item No.

	@Column(name="TD015")
	private String forecastNo; // 預測代號 Forecast No.

	@Column(name="TD016")
	private String closeCode; // 結案碼 Closing Code

	@Column(name="TD017")
	private String sourceTypeNo; // 前置單據-單別 Lead Document- Source Type No

	@Column(name="TD018")
	private String leadDocSourceNo; // 前置單據-單號 Lead Document- Source No.

	@Column(name="TD019")
	private String sourceSeq; // 前置單據-序號 Lead Document- Source S/N

	@Column(name="TD020")
	private String remarks; // 備註 Remark

	@Column(name="TD023")
	private String smallUnit; // 小單位 Small Unit

	@Column(name="TD024")
	private BigDecimal giftQty; // 贈品量 Gift Qty

	@Column(name="TD026")
	private BigDecimal discountRate; // 折扣率 Discount Rate

	@Column(name="TD027")
	private String projectCode; // 專案代號 Project Code

	@Column(name="TD028")
	private String forecastSeq; // 預測序號 Forecast S/N

	@Column(name="TD029")
	private String packingMethod; // 包裝方式 Packing Method

	@Column(name="TD030")
	private BigDecimal grossWeightKg; // 毛重(Kg) G.W. (Kg)

	@Column(name="TD031")
	private BigDecimal cuftSize; // 材積(CUFT) Volume (CUFT)

	@Column(name="TD032")
	private BigDecimal soPackingQty; // 訂單包裝數量 Sales Order Packing Qty

	@Column(name="TD034")
	private BigDecimal giftPackingQty; // 贈品包裝量 Gift Packing Qty

	@Column(name="TD036")
	private String packingUnit; // 包裝單位 Packing Unit

	@Column(name="TD038")
	private String requisitionsPurchaseSupplierNo; // 請採購廠商 Requisitions Purchase Supplier No.

	@Column(name="TD039")
	private String itemGraphNo; // 圖號 Drawing No.

	@Column(name="TD045")
	private String source; // 來源 Source

	@Column(name="TD046")
	private String itemGraphNoVersion; // 圖號版次 Drawing Version

	@Column(name="TD049")
	private String type; // 類型 Type

	@Column(name="TD050")
	private BigDecimal prepareItemQty; // 備品量 Qty of spares

	@Column(name="TD052")
	private BigDecimal prepareItemPackingQty; // 備品包裝量 Packing Qty for spares

	@Column(name="TD067")
	private String prioritySeq; // 優先順序 Priority

	@Column(name="TD069")
	private String lockDeliveryDate; // 鎖定交期 Lock Delivery Date

	@Column(name="TD070")
	private BigDecimal taxRate; // 營業稅率 Tax Rate

	@Column(name="TD071")
	private String crmDocType; // CRM單別 CRM Doc Type

	@Column(name="TD072")
	private String crmDocNo; // CRM單號 CRM Doc No

	@Column(name="TD073")
	private String crmDocSeq; // CRM序號 CRM Doc S/N

	@Column(name="TD074")
	private String crmContractCode; // CRM合約代號 CRM Contract Code

	@Column(name="TD075")
	private String businessItemNo; // 業務品號 Business Item No.

	@Column(name="TD076")
	private BigDecimal valuationQty; // 計價數量 Pricing Qty

	@Column(name="TD077")
	private String valuationUnit; // 計價單位 Pricing Unit

	@Column(name="TD079")
	private String taxCode; // 稅別碼 Tax Code

	@Column(name="TD080")
	private BigDecimal discountAmount; // 折扣金額 Discount Amount

	@Column(name="TD081")
	private String exemptionIdentity; // 豁免身分 Exemption Identity

	@Column(name="TD082")
	private String exemptionNo; // 豁免No. Exemption No.

	public SalesOrderDetailDataId getId() {
		return id;
	}

	public void setId(SalesOrderDetailDataId id) {
		this.id = id;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public String getWarehouseNo() {
		return warehouseNo;
	}

	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}

	public BigDecimal getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPlanDeliveryDate() {
		return planDeliveryDate;
	}

	public void setPlanDeliveryDate(String planDeliveryDate) {
		this.planDeliveryDate = planDeliveryDate;
	}

	public String getCustomerItem() {
		return customerItem;
	}

	public void setCustomerItem(String customerItem) {
		this.customerItem = customerItem;
	}

	public String getForecastNo() {
		return forecastNo;
	}

	public void setForecastNo(String forecastNo) {
		this.forecastNo = forecastNo;
	}

	public String getCloseCode() {
		return closeCode;
	}

	public void setCloseCode(String closeCode) {
		this.closeCode = closeCode;
	}

	public String getSourceTypeNo() {
		return sourceTypeNo;
	}

	public void setSourceTypeNo(String sourceTypeNo) {
		this.sourceTypeNo = sourceTypeNo;
	}

	public String getLeadDocSourceNo() {
		return leadDocSourceNo;
	}

	public void setLeadDocSourceNo(String leadDocSourceNo) {
		this.leadDocSourceNo = leadDocSourceNo;
	}

	public String getSourceSeq() {
		return sourceSeq;
	}

	public void setSourceSeq(String sourceSeq) {
		this.sourceSeq = sourceSeq;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSmallUnit() {
		return smallUnit;
	}

	public void setSmallUnit(String smallUnit) {
		this.smallUnit = smallUnit;
	}

	public BigDecimal getGiftQty() {
		return giftQty;
	}

	public void setGiftQty(BigDecimal giftQty) {
		this.giftQty = giftQty;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getForecastSeq() {
		return forecastSeq;
	}

	public void setForecastSeq(String forecastSeq) {
		this.forecastSeq = forecastSeq;
	}

	public String getPackingMethod() {
		return packingMethod;
	}

	public void setPackingMethod(String packingMethod) {
		this.packingMethod = packingMethod;
	}

	public BigDecimal getGrossWeightKg() {
		return grossWeightKg;
	}

	public void setGrossWeightKg(BigDecimal grossWeightKg) {
		this.grossWeightKg = grossWeightKg;
	}

	public BigDecimal getCuftSize() {
		return cuftSize;
	}

	public void setCuftSize(BigDecimal cuftSize) {
		this.cuftSize = cuftSize;
	}

	public BigDecimal getSoPackingQty() {
		return soPackingQty;
	}

	public void setSoPackingQty(BigDecimal soPackingQty) {
		this.soPackingQty = soPackingQty;
	}

	public BigDecimal getGiftPackingQty() {
		return giftPackingQty;
	}

	public void setGiftPackingQty(BigDecimal giftPackingQty) {
		this.giftPackingQty = giftPackingQty;
	}

	public String getPackingUnit() {
		return packingUnit;
	}

	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}

	public String getRequisitionsPurchaseSupplierNo() {
		return requisitionsPurchaseSupplierNo;
	}

	public void setRequisitionsPurchaseSupplierNo(String requisitionsPurchaseSupplierNo) {
		this.requisitionsPurchaseSupplierNo = requisitionsPurchaseSupplierNo;
	}

	public String getItemGraphNo() {
		return itemGraphNo;
	}

	public void setItemGraphNo(String itemGraphNo) {
		this.itemGraphNo = itemGraphNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getItemGraphNoVersion() {
		return itemGraphNoVersion;
	}

	public void setItemGraphNoVersion(String itemGraphNoVersion) {
		this.itemGraphNoVersion = itemGraphNoVersion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrepareItemQty() {
		return prepareItemQty;
	}

	public void setPrepareItemQty(BigDecimal prepareItemQty) {
		this.prepareItemQty = prepareItemQty;
	}

	public BigDecimal getPrepareItemPackingQty() {
		return prepareItemPackingQty;
	}

	public void setPrepareItemPackingQty(BigDecimal prepareItemPackingQty) {
		this.prepareItemPackingQty = prepareItemPackingQty;
	}

	public String getPrioritySeq() {
		return prioritySeq;
	}

	public void setPrioritySeq(String prioritySeq) {
		this.prioritySeq = prioritySeq;
	}

	public String getLockDeliveryDate() {
		return lockDeliveryDate;
	}

	public void setLockDeliveryDate(String lockDeliveryDate) {
		this.lockDeliveryDate = lockDeliveryDate;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public String getCrmDocType() {
		return crmDocType;
	}

	public void setCrmDocType(String crmDocType) {
		this.crmDocType = crmDocType;
	}

	public String getCrmDocNo() {
		return crmDocNo;
	}

	public void setCrmDocNo(String crmDocNo) {
		this.crmDocNo = crmDocNo;
	}

	public String getCrmDocSeq() {
		return crmDocSeq;
	}

	public void setCrmDocSeq(String crmDocSeq) {
		this.crmDocSeq = crmDocSeq;
	}

	public String getCrmContractCode() {
		return crmContractCode;
	}

	public void setCrmContractCode(String crmContractCode) {
		this.crmContractCode = crmContractCode;
	}

	public String getBusinessItemNo() {
		return businessItemNo;
	}

	public void setBusinessItemNo(String businessItemNo) {
		this.businessItemNo = businessItemNo;
	}

	public BigDecimal getValuationQty() {
		return valuationQty;
	}

	public void setValuationQty(BigDecimal valuationQty) {
		this.valuationQty = valuationQty;
	}

	public String getValuationUnit() {
		return valuationUnit;
	}

	public void setValuationUnit(String valuationUnit) {
		this.valuationUnit = valuationUnit;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getExemptionIdentity() {
		return exemptionIdentity;
	}

	public void setExemptionIdentity(String exemptionIdentity) {
		this.exemptionIdentity = exemptionIdentity;
	}

	public String getExemptionNo() {
		return exemptionNo;
	}

	public void setExemptionNo(String exemptionNo) {
		this.exemptionNo = exemptionNo;
	}

	@Override
	public String toString() {
		return "SalesOrderDetailData [id=" + id + ", itemNo=" + itemNo + ", itemName=" + itemName + ", itemSpec="
				+ itemSpec + ", warehouseNo=" + warehouseNo + ", orderQty=" + orderQty + ", unit=" + unit + ", price="
				+ price + ", amount=" + amount + ", planDeliveryDate=" + planDeliveryDate + ", customerItem="
				+ customerItem + ", forecastNo=" + forecastNo + ", closeCode=" + closeCode + ", sourceTypeNo="
				+ sourceTypeNo + ", leadDocSourceNo=" + leadDocSourceNo + ", sourceSeq=" + sourceSeq + ", remarks="
				+ remarks + ", smallUnit=" + smallUnit + ", giftQty=" + giftQty + ", discountRate=" + discountRate
				+ ", projectCode=" + projectCode + ", forecastSeq=" + forecastSeq + ", packingMethod=" + packingMethod
				+ ", grossWeightKg=" + grossWeightKg + ", cuftSize=" + cuftSize + ", soPackingQty=" + soPackingQty
				+ ", giftPackingQty=" + giftPackingQty + ", packingUnit=" + packingUnit
				+ ", requisitionsPurchaseSupplierNo=" + requisitionsPurchaseSupplierNo + ", itemGraphNo=" + itemGraphNo
				+ ", source=" + source + ", itemGraphNoVersion=" + itemGraphNoVersion + ", type=" + type
				+ ", prepareItemQty=" + prepareItemQty + ", prepareItemPackingQty=" + prepareItemPackingQty
				+ ", prioritySeq=" + prioritySeq + ", lockDeliveryDate=" + lockDeliveryDate + ", taxRate=" + taxRate
				+ ", crmDocType=" + crmDocType + ", crmDocNo=" + crmDocNo + ", crmDocSeq=" + crmDocSeq
				+ ", crmContractCode=" + crmContractCode + ", businessItemNo=" + businessItemNo + ", valuationQty="
				+ valuationQty + ", valuationUnit=" + valuationUnit + ", taxCode=" + taxCode + ", discountAmount="
				+ discountAmount + ", exemptionIdentity=" + exemptionIdentity + ", exemptionNo=" + exemptionNo + "]";
	}
	
	





}

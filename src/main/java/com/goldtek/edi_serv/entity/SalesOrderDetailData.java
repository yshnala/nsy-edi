package com.goldtek.edi_serv.entity;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SalesOrderDetailData {

    // 訂單單別
    // TABLE: COPTD.TD001, 欄位型態: nchar, 欄位長度: 4, 欄位值不可空白
    private String so_type_no;

    // 訂單單號
    // TABLE: COPTD.TD002, 欄位型態: nchar, 欄位長度: 11, 新增時請傳入空白，以自動取號
    private String so_no;

    // 訂單序號
    // TABLE: COPTD.TD003, 欄位型態: nchar, 欄位長度: 4, 欄位值不可空白
    private String so_seq;

    // 品號
    // TABLE: COPTD.TD004, 欄位型態: nvarchar, 欄位長度: 40, 欄位值不可空白
    private String item_no;

    // 品名
    // TABLE: COPTD.TD005, 欄位型態: nvarchar, 欄位長度: 120
    private String item_name;

    // 規格
    // TABLE: COPTD.TD006, 欄位型態: nvarchar, 欄位長度: 120
    private String item_spec;

    // 庫別
    // TABLE: COPTD.TD007, 欄位型態: nvarchar, 欄位長度: 10, 欄位值不可空白
    private String warehouse_no;

    // 訂單數量
    // TABLE: COPTD.TD008, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal order_qty;

    // 單位
    // TABLE: COPTD.TD010, 欄位型態: nvarchar, 欄位長度: 6, 欄位值不可空白
    private String unit;

    // 單價
    // TABLE: COPTD.TD011, 欄位型態: numeric, 欄位長度: 21.6, 預設值: 0, 欄位值不可空白
    private BigDecimal price;

    // 金額
    // TABLE: COPTD.TD012, 欄位型態: numeric, 欄位長度: 21.6, 預設值: 0, 欄位值不可空白
    private BigDecimal amount;

    // 預交日
    // TABLE: COPTD.TD013, 欄位型態: nvarchar, 欄位長度: 8, 格式: 西元年月日 (YYYYMMDD)
    private String plan_delivery_date;

    // 客戶品號
    // TABLE: COPTD.TD014, 欄位型態: nvarchar, 欄位長度: 40
    private String customer_item;

    // 預測代號
    // TABLE: COPTD.TD015, 欄位型態: nvarchar, 欄位長度: 11
    private String forecast_no;

    // 結案碼
    // TABLE: COPTD.TD016, 欄位型態: nvarchar, 欄位長度: 1, 預設值: N, 欄位值不可空白
    private String close_code;

    // 前置單據-單別
    // TABLE: COPTD.TD017, 欄位型態: nvarchar, 欄位長度: 4
    private String source_type_no;

    // 前置單據-單號
    // TABLE: COPTD.TD018, 欄位型態: nvarchar, 欄位長度: 11
    private String lead_doc_source_no;

    // 前置單據-序號
    // TABLE: COPTD.TD019, 欄位型態: nvarchar, 欄位長度: 4
    private String source_seq;

    // 備註
    // TABLE: COPTD.TD020, 欄位型態: nvarchar, 欄位長度: 255
    private String remarks;

    // 小單位
    // TABLE: COPTD.TD023, 欄位型態: nvarchar, 欄位長度: 6
    private String small_unit;

    // 贈品量
    // TABLE: COPTD.TD024, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal gift_qty;

    // 折扣率
    // TABLE: COPTD.TD026, 欄位型態: numeric, 欄位長度: 8.5, 若 5%，則存入值為 0.0500, 預設值: 0, 欄位值不可空白
    private BigDecimal discount_rate;

    // 專案代號
    // TABLE: COPTD.TD027, 欄位型態: nvarchar, 欄位長度: 20
    private String project_code;

    // 預測序號
    // TABLE: COPTD.TD028, 欄位型態: nvarchar, 欄位長度: 4
    private String forecast_seq;

    // 包裝方式
    // TABLE: COPTD.TD029, 欄位型態: nvarchar, 欄位長度: 3
    private String packing_method;

    // 毛重 (Kg)
    // TABLE: COPTD.TD030, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal gross_weight_kg;

    // 材積 (CUFT)
    // TABLE: COPTD.TD031, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal cuft_size;

    // 訂單包裝數量
    // TABLE: COPTD.TD032, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal so_packing_qty;

    // 贈品包裝量
    // TABLE: COPTD.TD034, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal gift_packing_qty;

    // 包裝單位
    // TABLE: COPTD.TD036, 欄位型態: nvarchar, 欄位長度: 6
    private String packing_unit;

    // 請採購廠商
    // TABLE: COPTD.TD038, 欄位型態: nvarchar, 欄位長度: 10
    private String requisitions_purchase_supplier_no;

    // 圖號
    // TABLE: COPTD.TD039, 欄位型態: nvarchar, 欄位長度: 40
    private String item_graph_no;

    // 來源
    // TABLE: COPTD.TD045, 欄位型態: nvarchar, 欄位長度: 1, 欄位值不可空白
    private String source;

    // 圖號版次
    // TABLE: COPTD.TD046, 欄位型態: nvarchar, 欄位長度: 4, 只可為數字
    private String item_graph_no_version;

    // 類型
    // TABLE: COPTD.TD049, 欄位型態: nvarchar, 欄位長度: 1, 預設值: 1, 欄位值不可空白
    private String type;

    // 備品量
    // TABLE: COPTD.TD050, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal prepare_item_qty;

    // 備品包裝量
    // TABLE: COPTD.TD052, 欄位型態: numeric, 欄位長度: 16.3, 預設值: 0, 欄位值須 >= 0, 欄位值不可空白
    private BigDecimal prepare_item_packing_qty;

    // 優先順序
    // TABLE: COPTD.TD067, 欄位型態: nvarchar, 欄位長度: 5, 預設值: 00001
    private String priority;

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

	public String getSo_seq() {
		return so_seq;
	}

	public void setSo_seq(String so_seq) {
		this.so_seq = so_seq;
	}

	public String getItem_no() {
		return item_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_spec() {
		return item_spec;
	}

	public void setItem_spec(String item_spec) {
		this.item_spec = item_spec;
	}

	public String getWarehouse_no() {
		return warehouse_no;
	}

	public void setWarehouse_no(String warehouse_no) {
		this.warehouse_no = warehouse_no;
	}

	public BigDecimal getOrder_qty() {
		return order_qty;
	}

	public void setOrder_qty(BigDecimal order_qty) {
		this.order_qty = order_qty;
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

	public String getPlan_delivery_date() {
		return plan_delivery_date;
	}

	public void setPlan_delivery_date(String plan_delivery_date) {
		this.plan_delivery_date = plan_delivery_date;
	}

	public String getCustomer_item() {
		return customer_item;
	}

	public void setCustomer_item(String customer_item) {
		this.customer_item = customer_item;
	}

	public String getForecast_no() {
		return forecast_no;
	}

	public void setForecast_no(String forecast_no) {
		this.forecast_no = forecast_no;
	}

	public String getClose_code() {
		return close_code;
	}

	public void setClose_code(String close_code) {
		this.close_code = close_code;
	}

	public String getSource_type_no() {
		return source_type_no;
	}

	public void setSource_type_no(String source_type_no) {
		this.source_type_no = source_type_no;
	}

	public String getLead_doc_source_no() {
		return lead_doc_source_no;
	}

	public void setLead_doc_source_no(String lead_doc_source_no) {
		this.lead_doc_source_no = lead_doc_source_no;
	}

	public String getSource_seq() {
		return source_seq;
	}

	public void setSource_seq(String source_seq) {
		this.source_seq = source_seq;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSmall_unit() {
		return small_unit;
	}

	public void setSmall_unit(String small_unit) {
		this.small_unit = small_unit;
	}

	public BigDecimal getGift_qty() {
		return gift_qty;
	}

	public void setGift_qty(BigDecimal gift_qty) {
		this.gift_qty = gift_qty;
	}

	public BigDecimal getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(BigDecimal discount_rate) {
		this.discount_rate = discount_rate;
	}

	public String getProject_code() {
		return project_code;
	}

	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}

	public String getForecast_seq() {
		return forecast_seq;
	}

	public void setForecast_seq(String forecast_seq) {
		this.forecast_seq = forecast_seq;
	}

	public String getPacking_method() {
		return packing_method;
	}

	public void setPacking_method(String packing_method) {
		this.packing_method = packing_method;
	}

	public BigDecimal getGross_weight_kg() {
		return gross_weight_kg;
	}

	public void setGross_weight_kg(BigDecimal gross_weight_kg) {
		this.gross_weight_kg = gross_weight_kg;
	}

	public BigDecimal getCuft_size() {
		return cuft_size;
	}

	public void setCuft_size(BigDecimal cuft_size) {
		this.cuft_size = cuft_size;
	}

	public BigDecimal getSo_packing_qty() {
		return so_packing_qty;
	}

	public void setSo_packing_qty(BigDecimal so_packing_qty) {
		this.so_packing_qty = so_packing_qty;
	}

	public BigDecimal getGift_packing_qty() {
		return gift_packing_qty;
	}

	public void setGift_packing_qty(BigDecimal gift_packing_qty) {
		this.gift_packing_qty = gift_packing_qty;
	}

	public String getPacking_unit() {
		return packing_unit;
	}

	public void setPacking_unit(String packing_unit) {
		this.packing_unit = packing_unit;
	}

	public String getRequisitions_purchase_supplier_no() {
		return requisitions_purchase_supplier_no;
	}

	public void setRequisitions_purchase_supplier_no(String requisitions_purchase_supplier_no) {
		this.requisitions_purchase_supplier_no = requisitions_purchase_supplier_no;
	}

	public String getItem_graph_no() {
		return item_graph_no;
	}

	public void setItem_graph_no(String item_graph_no) {
		this.item_graph_no = item_graph_no;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getItem_graph_no_version() {
		return item_graph_no_version;
	}

	public void setItem_graph_no_version(String item_graph_no_version) {
		this.item_graph_no_version = item_graph_no_version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrepare_item_qty() {
		return prepare_item_qty;
	}

	public void setPrepare_item_qty(BigDecimal prepare_item_qty) {
		this.prepare_item_qty = prepare_item_qty;
	}

	public BigDecimal getPrepare_item_packing_qty() {
		return prepare_item_packing_qty;
	}

	public void setPrepare_item_packing_qty(BigDecimal prepare_item_packing_qty) {
		this.prepare_item_packing_qty = prepare_item_packing_qty;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "SalesOrderDetailData [so_type_no=" + so_type_no + ", so_no=" + so_no + ", so_seq=" + so_seq
				+ ", item_no=" + item_no + ", item_name=" + item_name + ", item_spec=" + item_spec + ", warehouse_no="
				+ warehouse_no + ", order_qty=" + order_qty + ", unit=" + unit + ", price=" + price + ", amount="
				+ amount + ", plan_delivery_date=" + plan_delivery_date + ", customer_item=" + customer_item
				+ ", forecast_no=" + forecast_no + ", close_code=" + close_code + ", source_type_no=" + source_type_no
				+ ", lead_doc_source_no=" + lead_doc_source_no + ", source_seq=" + source_seq + ", remarks=" + remarks
				+ ", small_unit=" + small_unit + ", gift_qty=" + gift_qty + ", discount_rate=" + discount_rate
				+ ", project_code=" + project_code + ", forecast_seq=" + forecast_seq + ", packing_method="
				+ packing_method + ", gross_weight_kg=" + gross_weight_kg + ", cuft_size=" + cuft_size
				+ ", so_packing_qty=" + so_packing_qty + ", gift_packing_qty=" + gift_packing_qty + ", packing_unit="
				+ packing_unit + ", requisitions_purchase_supplier_no=" + requisitions_purchase_supplier_no
				+ ", item_graph_no=" + item_graph_no + ", source=" + source + ", item_graph_no_version="
				+ item_graph_no_version + ", type=" + type + ", prepare_item_qty=" + prepare_item_qty
				+ ", prepare_item_packing_qty=" + prepare_item_packing_qty + ", priority=" + priority + "]";
	}
    
    
    
}
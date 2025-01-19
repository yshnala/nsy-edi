package com.goldtek.edi_serv.entity;

import java.math.BigDecimal;

// 訂單行類
public class OrderLine {
    private String lineNumber;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal unitPrice;
    private String productId;
    private String productDescription;

    // Getters and setters
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return String.format("行號: %s, 產品: %s, 數量: %s %s, 單價: %s",
            lineNumber, productDescription, quantity, unit, unitPrice);
    }
}
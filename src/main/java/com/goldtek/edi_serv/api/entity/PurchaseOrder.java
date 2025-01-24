package com.goldtek.edi_serv.api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// 採購訂單類
public class PurchaseOrder {
    private String senderID;
    private String receiverID;
    private String orderType;
    private String purchaseOrderNumber;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Address buyerAddress;
    private Address shipToAddress;
    private List<OrderLine> orderLines;
    private int totalLines;
    private int totalQuantity;
    private Address lastProcessedAddress;

    public PurchaseOrder() {
        this.orderLines = new ArrayList<>();
    }

    // Getters and setters
    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setBuyerAddress(Address buyerAddress) {
        this.buyerAddress = buyerAddress;
        this.lastProcessedAddress = buyerAddress;
    }

    public void setShipToAddress(Address shipToAddress) {
        this.shipToAddress = shipToAddress;
        this.lastProcessedAddress = shipToAddress;
    }

    public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Address getLastProcessedAddress() {
        return this.lastProcessedAddress;
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public OrderLine getLastOrderLine() {
        return !orderLines.isEmpty() ? orderLines.get(orderLines.size() - 1) : null;
    }

    // 計算訂單總金額
    public BigDecimal calculateTotal() {
        return orderLines.stream()
            .map(line -> line.getUnitPrice().multiply(line.getQuantity()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("採購訂單信息:\n");
        sb.append("訂單號: ").append(purchaseOrderNumber).append("\n");
        sb.append("訂單日期: ").append(orderDate).append("\n");
        sb.append("交貨日期: ").append(deliveryDate).append("\n");
        sb.append("訂單總金額: ").append(calculateTotal()).append("\n");
        sb.append("總行數: ").append(totalLines).append("\n");
        return sb.toString();
    }
}
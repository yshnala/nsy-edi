package com.goldtek.edi_serv.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.goldtek.edi_serv.entity.Address;
import com.goldtek.edi_serv.entity.OrderLine;
import com.goldtek.edi_serv.entity.PurchaseOrder;

// 主要的EDI處理類
public class EDI850Processor {
    private String isaControlNumber;
    private PurchaseOrder purchaseOrder;

    public EDI850Processor() {
        this.purchaseOrder = new PurchaseOrder();
    }

    public void processEDI(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] segments = line.split("~");
                for (String segment : segments) {
                    processSegment(segment);
                }
            }
        }
    }

    private void processSegment(String segment) {
        String[] elements = segment.split("\\*");
        String segmentId = elements[0];

        switch (segmentId) {
            case "ISA":
                processISA(elements);
                break;
            case "BEG":
                processBEG(elements);
                break;
            case "DTM":
                processDTM(elements);
                break;
            case "N1":
                processN1(elements);
                break;
            case "N3":
                processN3(elements);
                break;
            case "N4":
                processN4(elements);
                break;
            case "PO1":
                processPO1(elements);
                break;
            case "PID":
                processPID(elements);
                break;
            case "CTT":
                processCTT(elements);
                break;
        }
    }

    private void processISA(String[] elements) {
        this.isaControlNumber = elements[13];
        this.purchaseOrder.setSenderID(elements[6].trim());
        this.purchaseOrder.setReceiverID(elements[8].trim());
    }

    private void processBEG(String[] elements) {
        this.purchaseOrder.setOrderType(elements[1]);
        this.purchaseOrder.setPurchaseOrderNumber(elements[3]);
        this.purchaseOrder.setOrderDate(parseDate(elements[5]));
    }

    private void processDTM(String[] elements) {
        if ("002".equals(elements[1])) {
            this.purchaseOrder.setDeliveryDate(parseDate(elements[2]));
        }
    }

    private void processN1(String[] elements) {
        Address address = new Address();
        address.setName(elements[2]);
        
        if ("BT".equals(elements[1])) {
            this.purchaseOrder.setBuyerAddress(address);
        } else if ("ST".equals(elements[1])) {
            this.purchaseOrder.setShipToAddress(address);
        }
    }

    private void processN3(String[] elements) {
        Address lastAddress = this.purchaseOrder.getLastProcessedAddress();
        if (lastAddress != null) {
            lastAddress.setStreet(elements[1]);
        }
    }

    private void processN4(String[] elements) {
        Address lastAddress = this.purchaseOrder.getLastProcessedAddress();
        if (lastAddress != null) {
            lastAddress.setCity(elements[1]);
            lastAddress.setState(elements[2]);
            lastAddress.setZipCode(elements[3]);
            lastAddress.setCountry(elements[4]);
        }
    }

    private void processPO1(String[] elements) {
        OrderLine orderLine = new OrderLine();
        orderLine.setLineNumber(elements[1]);
        orderLine.setQuantity(new BigDecimal(elements[2]));
        orderLine.setUnit(elements[3]);
        orderLine.setUnitPrice(new BigDecimal(elements[4]).movePointLeft(2));
        orderLine.setProductId(elements[7]);
        this.purchaseOrder.addOrderLine(orderLine);
    }

    private void processPID(String[] elements) {
        if (!this.purchaseOrder.getOrderLines().isEmpty()) {
            OrderLine lastLine = this.purchaseOrder.getLastOrderLine();
            lastLine.setProductDescription(elements[5]);
        }
    }

    private void processCTT(String[] elements) {
        this.purchaseOrder.setTotalLines(Integer.parseInt(elements[1]));
        this.purchaseOrder.setTotalQuantity(Integer.parseInt(elements[2]));
    }

    private LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(date, formatter);
    }

    // 獲取處理後的訂單
    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }
}







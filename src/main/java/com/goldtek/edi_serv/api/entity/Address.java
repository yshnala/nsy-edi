package com.goldtek.edi_serv.api.entity;
// 地址類
public class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s %s %s",
            name, street, city, state, zipCode, country);
    }
}
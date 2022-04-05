package com.propify.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.propify.challenge.entity.Address;
import com.propify.challenge.entity.PropertyType;

public class PropertyDTO {

    private int id; // must be null for INSERT and not null for UPDATE

    @JsonProperty("create_time")
    private String createTime;

    private PropertyType type;

    @JsonProperty("rent_price")
    private double rentPrice; // must be greater than 0, 2 decimal places

    private Address address; // must not be null

    @JsonProperty("email_address")
    private String emailAddress; // must be a valid email address

    private String code; // not null, only uppercase letters or numbers, 10 characters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

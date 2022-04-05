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
}

package com.propify.challenge.dto;

import com.propify.challenge.entity.PropertyType;

import java.util.Map;

public class PropertyReport {

    Integer totalQuantity;

    Map<PropertyType, Integer> quantityPerType;

    double averageRentPrice;

    Integer illinoisQuantity;
}

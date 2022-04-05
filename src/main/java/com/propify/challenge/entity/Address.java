package com.propify.challenge.entity;

public class Address {

    private String street; // must not be null or blank

    private String city; // must not be null or blank

    private String state; // 2-letter code, must not be null or blank

    private String zip; // 5-digit code, must not be null or blank

    private String timezone; // Must be a valid timezone

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}

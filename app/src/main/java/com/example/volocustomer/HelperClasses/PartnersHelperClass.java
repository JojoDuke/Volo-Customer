package com.example.volocustomer.HelperClasses;

public class PartnersHelperClass {

    String vendor, product, distance, duration;

    public PartnersHelperClass(String vendor, String product, String distance, String duration) {
        this.vendor = vendor;
        this.product = product;
        this.distance = distance;
        this.duration =duration;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }

    public String getProduct() {
        return product;
    }

}

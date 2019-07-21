package com.creativeshare.humhum.models;

import java.io.Serializable;

public class BillModel implements Serializable {

    private String bill_image;
    private String bill_cost;
    private String delivery_cost;

    public BillModel(String bill_image, String bill_cost, String delivery_cost) {
        this.bill_image = bill_image;
        this.bill_cost = bill_cost;
        this.delivery_cost = delivery_cost;
    }

    public String getBill_image() {
        return bill_image;
    }

    public String getBill_cost() {
        return bill_cost;
    }

    public String getDelivery_cost() {
        return delivery_cost;
    }
}

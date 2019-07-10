package com.creativeshare.humhum.models;

import java.io.Serializable;

public class PlaceModel implements Serializable {
    private String id;
    private String place_id;
    private String name;
    private String icon;
    private float rating;
    private double lat;
    private double lng;
    private String address;
    private boolean isOpenNow;

    public PlaceModel(String id, String place_id, String name, String icon, float rating, double lat, double lng, String address) {
        this.id = id;
        this.place_id = place_id;
        this.name = name;
        this.icon = icon;
        this.rating = rating;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public float getRating() {
        return rating;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public boolean isOpenNow() {
        return isOpenNow;
    }


    public void setOpenNow(boolean openNow) {
        isOpenNow = openNow;
    }


    public String getAddress() {
        return address;
    }
}

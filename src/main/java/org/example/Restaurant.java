package org.example;

import java.util.*;

public class Restaurant {
    private String id;
    private String name;
    private String city;
    private String area;
    private String cuisine;
    private double rating;
    private double costForTwo;
    private boolean isVeg;
    private Map<String, List<Slot>> slots;

    public Restaurant(String id, String name, String city, String area, String cuisine, double rating, double costForTwo, boolean isVeg) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.area = area;
        this.cuisine = cuisine;
        this.rating = rating;
        this.costForTwo = costForTwo;
        this.isVeg = isVeg;
        this.slots = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getCuisine() {
        return cuisine;
    }

    public double getRating() {
        return rating;
    }

    public double getCostForTwo() {
        return costForTwo;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public Map<String, List<Slot>> getSlots() {
        return slots;
    }
}

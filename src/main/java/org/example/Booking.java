package org.example;

public class Booking {
    private String restaurantId;
    private String date;
    private String time;
    private int numberOfPeople;

    public Booking(String restaurantId, String date, String time, int numberOfPeople) {
        this.restaurantId = restaurantId;
        this.date = date;
        this.time = time;
        this.numberOfPeople = numberOfPeople;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}

package org.example;

import java.util.*;

public class RestaurantBookingSystem {
    private RestaurantService restaurantService;
    private BookingService bookingService;

    public RestaurantBookingSystem() {
        this.restaurantService = new RestaurantService();
        this.bookingService = new BookingService(restaurantService);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurantService.registerRestaurant(restaurant);
    }

    public void addSlots(String restaurantId, String date, List<Slot> slots) {
        restaurantService.addSlots(restaurantId, date, slots);
    }

    public List<Restaurant> searchRestaurant(Map<String, String> filters) {
        return restaurantService.searchRestaurant(filters);
    }

    public boolean bookTable(String restaurantId, String date, String time, int numberOfPeople) {
        return bookingService.bookTable(restaurantId, date, time, numberOfPeople);
    }
}

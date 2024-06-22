package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RestaurantBookingSystem system = new RestaurantBookingSystem();

        // Registering a restaurant
        Restaurant restaurant1 = new Restaurant("1", "The Great Restaurant", "City1", "Area1", "Italian", 4.5, 500, true);
        Restaurant restaurant2 = new Restaurant("2", "Seafood Delight", "City1", "Area2", "Seafood", 4.7, 700, false);
        system.registerRestaurant(restaurant1);
        system.registerRestaurant(restaurant2);

        // Adding slots to the restaurants
        List<Slot> slotsForRestaurant1 = Arrays.asList(new Slot("18:00", 10), new Slot("19:00", 10), new Slot("20:00", 10));
        system.addSlots("1", "2024-06-25", slotsForRestaurant1);

        List<Slot> slotsForRestaurant2 = Arrays.asList(new Slot("18:00", 15), new Slot("19:00", 15), new Slot("20:00", 15));
        system.addSlots("2", "2024-06-25", slotsForRestaurant2);

        // Searching for restaurants
        Map<String, String> filters = new HashMap<>();
        filters.put("city", "City1");
        filters.put("cuisine", "Italian");

        List<Restaurant> searchResults = system.searchRestaurant(filters);
        System.out.println("Search Results:");
        for (Restaurant r : searchResults) {
            System.out.println("Found: " + r.getName());
        }

        // Booking a table
        boolean bookingSuccess1 = system.bookTable("1", "2024-06-25", "18:00", 4);
        System.out.println("Booking Success for The Great Restaurant at 18:00: " + bookingSuccess1);

        boolean bookingSuccess2 = system.bookTable("2", "2024-06-25", "19:00", 5);
        System.out.println("Booking Success for Seafood Delight at 19:00: " + bookingSuccess2);

        // Trying to overbook a slot
        boolean bookingFailure = system.bookTable("1", "2024-06-25", "18:00", 7);
        System.out.println("Booking Success for The Great Restaurant at 18:00 (overbooking attempt): " + bookingFailure);
    }
}

package org.example;
import java.util.*;

public class BookingService {
    private RestaurantService restaurantService;
    private List<Booking> bookings;

    public BookingService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
        this.bookings = new ArrayList<>();
    }

    public synchronized boolean bookTable(String restaurantId, String date, String time, int numberOfPeople) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        if (restaurant != null) {
            List<Slot> slots = restaurant.getSlots().get(date);
            if (slots != null) {
                for (Slot slot : slots) {
                    if (slot.getTime().equals(time) && slot.getCapacity() >= numberOfPeople) {
                        slot.setCapacity(slot.getCapacity() - numberOfPeople);
                        bookings.add(new Booking(restaurantId, date, time, numberOfPeople));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


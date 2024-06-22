package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantService {
    private Map<String, Restaurant> restaurants;

    public RestaurantService() {
        this.restaurants = new HashMap<>();
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public void addSlots(String restaurantId, String date, List<Slot> slots) {
        if (restaurants.containsKey(restaurantId)) {
            Restaurant restaurant = restaurants.get(restaurantId);
            restaurant.getSlots().put(date, slots);
        }
    }

    public List<Restaurant> searchRestaurant(Map<String, String> filters) {
        return restaurants.values().stream().filter(restaurant -> {
            boolean matches = true;
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                switch (filter.getKey()) {
                    case "name":
                        matches &= restaurant.getName().equalsIgnoreCase(filter.getValue());
                        break;
                    case "city":
                        matches &= restaurant.getCity().equalsIgnoreCase(filter.getValue());
                        break;
                    case "area":
                        matches &= restaurant.getArea().equalsIgnoreCase(filter.getValue());
                        break;
                    case "cuisine":
                        matches &= restaurant.getCuisine().equalsIgnoreCase(filter.getValue());
                        break;
                    case "rating":
                        matches &= restaurant.getRating() >= Double.parseDouble(filter.getValue());
                        break;
                    case "costForTwo":
                        matches &= restaurant.getCostForTwo() <= Double.parseDouble(filter.getValue());
                        break;
                    case "isVeg":
                        matches &= restaurant.isVeg() == Boolean.parseBoolean(filter.getValue());
                        break;
                    default:
                        break;
                }
            }
            return matches;
        }).collect(Collectors.toList());
    }

    public Restaurant getRestaurant(String restaurantId) {
        return restaurants.get(restaurantId);
    }
}

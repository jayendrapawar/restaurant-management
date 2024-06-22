package org.example;

public class Slot {
    private String time;
    private int capacity;

    public Slot(String time, int capacity) {
        this.time = time;
        this.capacity = capacity;
    }

    public String getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

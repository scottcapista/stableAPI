package com.mongodb.corpsa.pov.stableapi.model;


import java.util.Arrays;

public class Address {
    private boolean isPrimary;
    private String state;
    private String city;
    private String street;
    private Location location;

    public Address(boolean isPrimary, String state, String city, String street) {
        this.isPrimary = isPrimary;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public Address(){}

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        this.isPrimary = primary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "isPrimary=" + isPrimary +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", location=" + location +
                '}';
    }

    private class Location{
        private String type;
        private float[] coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(float[] coordinates) {
            this.coordinates = coordinates;
        }

        public Location(String type, float[] coordinates) {
            this.type = type;
            this.coordinates = coordinates;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "type='" + type + '\'' +
                    ", coordinates=" + Arrays.toString(coordinates) +
                    '}';
        }
    }
}

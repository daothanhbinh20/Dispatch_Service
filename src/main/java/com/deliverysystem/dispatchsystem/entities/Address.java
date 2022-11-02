package com.deliverysystem.dispatchsystem.entities;

public class Address {
    private final int addressId;
    private String addressName;
    private Coordination location;

    public Address(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Coordination getLocation() {
        return location;
    }

    public void setLocation(Coordination location) {
        this.location = location;
    }
}

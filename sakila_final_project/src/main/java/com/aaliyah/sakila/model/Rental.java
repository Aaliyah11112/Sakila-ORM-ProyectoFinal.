package com.aaliyah.sakila.model;

import java.time.LocalDateTime;

public class Rental extends Entity {
    private Inventory inventory;
    private Customer customer;
    private LocalDateTime rentalDate;

    public Rental() {}
    public Rental(int id, Inventory inventory, Customer customer, LocalDateTime rentalDate) {
        super(id); this.inventory = inventory; this.customer = customer; this.rentalDate = rentalDate;
    }

    public Inventory getInventory() { return inventory; }
    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public LocalDateTime getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDateTime rentalDate) { this.rentalDate = rentalDate; }

    @Override public String toString() {
        return "Rental{id="+id+", rentalDate="+rentalDate+"}";
    }
}

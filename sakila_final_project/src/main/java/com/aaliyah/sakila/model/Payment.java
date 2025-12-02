package com.aaliyah.sakila.model;

public class Payment extends Entity {
    private Rental rental;
    private double amount;

    public Payment() {}
    public Payment(int id, Rental rental, double amount) { super(id); this.rental = rental; this.amount = amount; }

    public Rental getRental() { return rental; }
    public void setRental(Rental rental) { this.rental = rental; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override public String toString() {
        return "Payment{id="+id+", amount="+amount+"}";
    }
}

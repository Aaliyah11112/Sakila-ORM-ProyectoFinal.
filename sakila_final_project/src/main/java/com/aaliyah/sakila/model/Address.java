package com.aaliyah.sakila.model;

public class Address extends Entity {
    private String address;
    private City city; // FK

    public Address() {}
    public Address(int id, String address, City city) { super(id); this.address = address; this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    @Override public String toString() {
        return "Address{id="+id+", address='"+address+"', city="+ (city!=null?city.getCity():"null") +"}";
    }
}

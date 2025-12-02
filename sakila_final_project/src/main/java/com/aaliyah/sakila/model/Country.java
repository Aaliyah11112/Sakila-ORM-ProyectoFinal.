package com.aaliyah.sakila.model;

public class Country extends Entity {
    private String country;

    public Country() {}
    public Country(int id, String country) { super(id); this.country = country; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override public String toString() {
        return "Country{id="+id+", country='"+country+"'}";
    }
}

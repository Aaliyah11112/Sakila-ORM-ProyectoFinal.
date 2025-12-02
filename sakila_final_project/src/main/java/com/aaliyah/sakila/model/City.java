package com.aaliyah.sakila.model;

public class City extends Entity {
    private String city;
    private Country country; // FK as object

    public City() {}
    public City(int id, String city, Country country) { super(id); this.city = city; this.country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    @Override public String toString() {
        return "City{id="+id+", city='"+city+"', country="+ (country!=null?country.getCountry():"null") +"}";
    }
}

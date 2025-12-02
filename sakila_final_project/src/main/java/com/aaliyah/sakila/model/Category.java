package com.aaliyah.sakila.model;

public class Category extends Entity {
    private String name;

    public Category() {}
    public Category(int id, String name) { super(id); this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override public String toString() {
        return "Category{id="+id+", name='"+name+"'}";
    }
}

package com.aaliyah.sakila.model;

public class Language extends Entity {
    private String name;

    public Language() {}
    public Language(int id, String name) { super(id); this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override public String toString() {
        return "Language{id="+id+", name='"+name+"'}";
    }
}

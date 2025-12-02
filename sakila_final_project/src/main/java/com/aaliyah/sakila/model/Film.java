package com.aaliyah.sakila.model;

public class Film extends Entity {
    private String title;
    private String description;

    public Film() {}
    public Film(int id, String title, String description) { super(id); this.title = title; this.description = description; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override public String toString() {
        return "Film{id="+id+", title='"+title+"'}";
    }
}

package com.aaliyah.sakila.model;


public class FilmCategory extends Entity {
    private Film film;
    private Category category;

    public FilmCategory() {}
    public FilmCategory(int id, Film film, Category category) { super(id); this.film = film; this.category = category; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    @Override public String toString() {
        return "FilmCategory{id="+id+", filmId="+ (film!=null?film.getId():"null") +", categoryId="+ (category!=null?category.getId():"null") +"}";
    }
}

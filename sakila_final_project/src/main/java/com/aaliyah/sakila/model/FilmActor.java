package com.aaliyah.sakila.model;


public class FilmActor extends Entity {
    private Film film;
    private Actor actor;

    public FilmActor() {}
    public FilmActor(int id, Film film, Actor actor) { super(id); this.film = film; this.actor = actor; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Actor getActor() { return actor; }
    public void setActor(Actor actor) { this.actor = actor; }

    @Override public String toString() {
        return "FilmActor{id="+id+", filmId="+ (film!=null?film.getId():"null") +", actorId="+ (actor!=null?actor.getId():"null") +"}";
    }
}

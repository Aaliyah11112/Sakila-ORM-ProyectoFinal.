package com.aaliyah.sakila.model;


public abstract class Entity {
    protected int id;
    protected boolean active = true;

    public Entity() {}

    public Entity(int id) { this.id = id; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}

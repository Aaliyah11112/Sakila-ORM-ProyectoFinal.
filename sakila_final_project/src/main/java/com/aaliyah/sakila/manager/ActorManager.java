package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Actor;

public class ActorManager implements CrudManager<Actor> {

    private final ArrayList<Actor> items = new ArrayList<>();

    @Override
    public void post(Actor obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Actor::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Actor get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Actor> get(String filter) {
        List<Actor> res = new ArrayList<>();
        for (Actor i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Actor obj) {
        Actor existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Actor e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Actor> all() {
        List<Actor> out = new ArrayList<>();
        for (Actor i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

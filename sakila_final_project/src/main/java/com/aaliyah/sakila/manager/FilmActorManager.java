package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.FilmActor;

public class FilmActorManager implements CrudManager<FilmActor> {

    private final ArrayList<FilmActor> items = new ArrayList<>();

    @Override
    public void post(FilmActor obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(FilmActor::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public FilmActor get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<FilmActor> get(String filter) {
        List<FilmActor> res = new ArrayList<>();
        for (FilmActor i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(FilmActor obj) {
        FilmActor existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        FilmActor e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<FilmActor> all() {
        List<FilmActor> out = new ArrayList<>();
        for (FilmActor i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

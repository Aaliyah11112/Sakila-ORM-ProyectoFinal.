package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.aaliyah.sakila.model.FilmActor;
import com.aaliyah.sakila.model.FilmCategory;

public class FilmCategoryManager implements CrudManager<FilmCategory> {

    private final ArrayList<FilmCategory> items = new ArrayList<>();

    @Override
    public void post(FilmCategory obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(FilmCategory::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public FilmCategory get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<FilmCategory> get(String filter) {
        List<FilmCategory> res = new ArrayList<>();
        for (FilmCategory i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(FilmCategory obj) {
        FilmCategory existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        FilmCategory e = get(id);
        if (e != null) e.setActive(false); 
    }

    @SuppressWarnings("unchecked")
    public List<FilmActor> all() {
        List<FilmActor> out = new ArrayList<>();
        for (FilmCategory i: items) if (i.isActive()) out.addAll((Collection<? extends FilmActor>) i);
        return out;
    }
}


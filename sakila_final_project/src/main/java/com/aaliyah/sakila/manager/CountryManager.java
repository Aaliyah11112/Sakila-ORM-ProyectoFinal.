package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Country;

public class CountryManager implements CrudManager<Country> {

    private final ArrayList<Country> items = new ArrayList<>();

    @Override
    public void post(Country obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Country::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Country get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Country> get(String filter) {
        List<Country> res = new ArrayList<>();
        for (Country i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Country obj) {
        Country existing = get(obj.getId());
        if (existing != null) {
           
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Country e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Country> all() {
        List<Country> out = new ArrayList<>();
        for (Country i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

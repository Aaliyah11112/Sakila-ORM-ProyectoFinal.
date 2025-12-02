package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.City;

public class CityManager implements CrudManager<City> {

    private final ArrayList<City> items = new ArrayList<>();

    @Override
    public void post(City obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(City::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public City get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<City> get(String filter) {
        List<City> res = new ArrayList<>();
        for (City i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(City obj) {
        City existing = get(obj.getId());
        if (existing != null) {
           
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        City e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<City> all() {
        List<City> out = new ArrayList<>();
        for (City i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

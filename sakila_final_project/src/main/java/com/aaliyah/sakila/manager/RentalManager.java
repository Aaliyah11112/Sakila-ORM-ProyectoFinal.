package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Rental;

public class RentalManager implements CrudManager<Rental> {

    private final ArrayList<Rental> items = new ArrayList<>();

    @Override
    public void post(Rental obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Rental::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Rental get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Rental> get(String filter) {
        List<Rental> res = new ArrayList<>();
        for (Rental i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Rental obj) {
        Rental existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Rental e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Rental> all() {
        List<Rental> out = new ArrayList<>();
        for (Rental i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

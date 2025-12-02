package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Store;

public class StoreManager implements CrudManager<Store> {

    private final ArrayList<Store> items = new ArrayList<>();

    @Override
    public void post(Store obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Store::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Store get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Store> get(String filter) {
        List<Store> res = new ArrayList<>();
        for (Store i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Store obj) {
        Store existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Store e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Store> all() {
        List<Store> out = new ArrayList<>();
        for (Store i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

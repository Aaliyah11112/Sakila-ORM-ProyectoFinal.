package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Inventory;

public class InventoryManager implements CrudManager<Inventory> {

    private final ArrayList<Inventory> items = new ArrayList<>();

    @Override
    public void post(Inventory obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Inventory::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Inventory get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Inventory> get(String filter) {
        List<Inventory> res = new ArrayList<>();
        for (Inventory i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Inventory obj) {
        Inventory existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Inventory e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Inventory> all() {
        List<Inventory> out = new ArrayList<>();
        for (Inventory i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

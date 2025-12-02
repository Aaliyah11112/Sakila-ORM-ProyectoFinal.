package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Staff;

public class StaffManager implements CrudManager<Staff> {

    private final ArrayList<Staff> items = new ArrayList<>();

    @Override
    public void post(Staff obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Staff::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Staff get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Staff> get(String filter) {
        List<Staff> res = new ArrayList<>();
        for (Staff i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Staff obj) {
        Staff existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Staff e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Staff> all() {
        List<Staff> out = new ArrayList<>();
        for (Staff i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

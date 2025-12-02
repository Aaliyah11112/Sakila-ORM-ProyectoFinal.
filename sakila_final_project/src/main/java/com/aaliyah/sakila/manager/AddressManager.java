package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Address;

public class AddressManager implements CrudManager<Address> {

    private final ArrayList<Address> items = new ArrayList<>();

    @Override
    public void post(Address obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Address::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Address get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Address> get(String filter) {
        List<Address> res = new ArrayList<>();
        for (Address i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Address obj) {
        Address existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Address e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Address> all() {
        List<Address> out = new ArrayList<>();
        for (Address i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

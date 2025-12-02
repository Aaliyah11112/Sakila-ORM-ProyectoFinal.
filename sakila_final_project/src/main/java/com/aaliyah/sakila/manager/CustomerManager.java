package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Customer;

public class CustomerManager implements CrudManager<Customer> {

    private final ArrayList<Customer> items = new ArrayList<>();

    @Override
    public void post(Customer obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Customer::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Customer get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Customer> get(String filter) {
        List<Customer> res = new ArrayList<>();
        for (Customer i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Customer obj) {
        Customer existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Customer e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Customer> all() {
        List<Customer> out = new ArrayList<>();
        for (Customer i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

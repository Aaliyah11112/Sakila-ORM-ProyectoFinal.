package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Category;

public class CategoryManager implements CrudManager<Category> {

    private final ArrayList<Category> items = new ArrayList<>();

    @Override
    public void post(Category obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Category::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Category get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Category> get(String filter) {
        List<Category> res = new ArrayList<>();
        for (Category i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Category obj) {
        Category existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Category e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Category> all() {
        List<Category> out = new ArrayList<>();
        for (Category i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

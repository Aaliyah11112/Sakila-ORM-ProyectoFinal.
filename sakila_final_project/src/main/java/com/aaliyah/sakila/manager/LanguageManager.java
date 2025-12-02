package com.aaliyah.sakila.manager;

import java.util.ArrayList;
import java.util.List;

import com.aaliyah.sakila.model.Language;

public class LanguageManager implements CrudManager<Language> {

    private final ArrayList<Language> items = new ArrayList<>();

    @Override
    public void post(Language obj) {
        if (obj.getId() == 0) {
            int next = items.stream().mapToInt(Language::getId).max().orElse(0) + 1;
            obj.setId(next);
        }
        items.add(obj);
    }

    @Override
    public Language get(int id) {
        return items.stream().filter(i -> i.getId() == id && i.isActive()).findFirst().orElse(null);
    }

    @Override
    public List<Language> get(String filter) {
        List<Language> res = new ArrayList<>();
        for (Language i: items) {
            if (!i.isActive()) continue;
            String s = i.toString();
            if (s.toLowerCase().contains(filter.toLowerCase())) res.add(i);
        }
        return res;
    }

    @Override
    public void put(Language obj) {
        Language existing = get(obj.getId());
        if (existing != null) {
            
            int idx = items.indexOf(existing);
            items.set(idx, obj);
        }
    }

    @Override
    public void delete(int id) {
        Language e = get(id);
        if (e != null) e.setActive(false); 
    }

    public List<Language> all() {
        List<Language> out = new ArrayList<>();
        for (Language i: items) if (i.isActive()) out.add(i);
        return out;
    }
}

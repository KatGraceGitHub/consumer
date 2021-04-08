package jee3060.design.service;


import jee3060.design.model.Hobby;

import java.util.List;

public interface HobbyService {
    public List<Hobby> findAll();

    public void create(Hobby hobby);

    public Hobby updateById(Hobby hobbyNew);

    public void deleteById(int id);

    public Hobby findById(int id);

    public void save(Hobby hobby);

    public int nextKey();

}

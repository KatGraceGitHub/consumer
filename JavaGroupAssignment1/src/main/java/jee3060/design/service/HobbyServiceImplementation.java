package jee3060.design.service;

import jee3060.design.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyServiceImplementation implements HobbyService {

    private static List<Hobby> hobbies = new ArrayList<>();

    @Override
    public List<Hobby> findAll() {
        return hobbies;
    }

    @Override
    public void create(Hobby hobby) {
        hobbies.add(hobby);
    }


    @Override
    public synchronized Hobby updateById(Hobby newHobby) {
        Hobby update = findById(newHobby.getHobbyId());
        update.setHobbyCategory(newHobby.getHobbyCategory());
        update.setHobbyName(newHobby.getHobbyName());
        update.setHobbyCategory(newHobby.getHobbyCategory());
        return update;
    }

    @Override
    public void save(Hobby hobby) {
        for (Hobby existingHobby : hobbies) {
            if (hobby.getHobbyId() == existingHobby.getHobbyId()) {
                hobbies.remove(existingHobby);
                break;
            }
        }
        hobbies.add(hobby);
    }

    @Override
    public void deleteById(int id) {
        for (Hobby hobby : hobbies) {
            if (hobby.getHobbyId() == id) {
                hobbies.remove(hobby);
                break;
            }
        }
    }

    @Override
    public Hobby findById(int id) {
        for (Hobby hobby : hobbies) {
            if (hobby.getHobbyId() == id) {
                return hobby;
            }
        }
        return null;
    }


    @Override
    public synchronized int nextKey() {
        int base = 0, nextId = 0;
        if (hobbies.size() > 0) {
            nextId = hobbies.stream().mapToInt(t -> t.getHobbyId()).max().getAsInt();
        } else {
            base = 1000;
        }
        nextId += base;
        nextId++;
        return nextId;
    }
}

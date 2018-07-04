package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoxServiceImpl implements FoxService {

    private FoxRepository repo;
    private Fox currentFox;

    @Autowired
    public FoxServiceImpl(FoxRepository repo) {
        this.repo = repo;
    }

    public void addFox(Fox fox) {
        repo.save(fox);
    }

    public int size() {
        return repo.findAll().size();
    }

    public boolean isOldPlayer(String name) {
        if (repo.findByName(name) == null) {
            return false;
        } else {
            return true;
        }
    }

    public Fox findByName(String name) {
        return repo.findByName(name);
    }

    public void saveNewFox(String petName) {
        repo.save(new Fox(petName));
    }

    public void setCurrentFox(Fox foxie) {
        this.currentFox = foxie;
    }
    public Fox getCurrentFox() {
        return currentFox;
    }

    public void setNutritionsToFox(Fox current,String drink, String food) {
        Fox fox = repo.findByName(current.getName());
        fox.setFood(food);
        fox.setDrink(drink);
        this.currentFox.setDrink(drink);
        this.currentFox.setFood(food);
        repo.save(fox);
    }

    public void setTrickToFox(Fox currentFox, String trick) {
        Fox fox = repo.findByName(currentFox.getName());
        fox.addTrick(trick);
        this.currentFox.addTrick(trick);
        repo.save(fox);
    }
}

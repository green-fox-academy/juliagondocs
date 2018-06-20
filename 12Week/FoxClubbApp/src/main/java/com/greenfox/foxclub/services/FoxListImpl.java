package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Fox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxListImpl implements FoxList {


    private List<Fox> foxList = new ArrayList<>();

    public void addFox(Fox fox) {
        foxList.add(fox);
    }

    public int size(){
        return foxList.size();
    }
}

package com.greenfox.foxes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Foxlist {

    List<Fox> foxList = new ArrayList<>();

    public List<Fox> getFoxList() {
        return foxList;
    }

    public void setFoxList(List<Fox> foxList) {
        this.foxList = foxList;
    }

    public void addFox(Fox fox) {
        foxList.add(fox);
    }

    public int getFoxIndex(String getHisIndex) {
        int thatsTheIndex = 0;
        for (int i = 0; i < foxList.size(); i++) {
            if (foxList.get(i).getName().equals(getHisIndex)) {
                thatsTheIndex = i;
            }
        }
        return thatsTheIndex;
    }
}
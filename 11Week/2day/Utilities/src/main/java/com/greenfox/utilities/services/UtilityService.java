package com.greenfox.utilities.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UtilityService {
    ArrayList<String> colors;
    Random random;

    public UtilityService() {
        colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("lime");
        colors.add("orange");
        colors.add("magenta");
        random = new Random();
    }

    public String randomColor() {
        return colors.get(random.nextInt(colors.size()));
    }

    public boolean validateEmail(String email) {
        char[] emailCharacters = email.toCharArray();
        char at = '@';
        char dot = '.';
        for (int i = 0; i < emailCharacters.length ; i++) {
            for (int j = 0; j < emailCharacters.length; j++) {
                if (emailCharacters[i] == at && emailCharacters[j] == dot && i < j)
                    return true;
            }
        }
        return false;
    }

    public String caesar(String text, int number) {
        String result = "";
        for(int i = 0; i < text.length(); i++) {
            result += (char)((int)text.charAt(i) + number);
        }
        return result;
    }

    public boolean isPositive (int number) {
        return (number>0);
    }
}

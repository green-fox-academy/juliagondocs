package com.greenfox.rest.services;

import com.greenfox.rest.models.Error;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestServiceImpl implements RestService {

    public Object doSomeMath(String inputWhat, int[] inputNumbers) {
        if (inputWhat != null && inputNumbers != null) {
            List<Integer> numberList = new ArrayList<>();
            for (int number : inputNumbers) {
                numberList.add(number);
            }
            if (inputWhat.equals("sum")) {
                return numberList.stream().mapToInt(Integer::intValue).sum();
            } else if (inputWhat.equals("multiply")) {
                return numberList.stream().reduce(1, (a, b) -> a * b);
            } else if (inputWhat.equals("double")) {
                return numberList.stream().mapToInt(i -> i * 2).boxed().collect(Collectors.toList());
            }
        }
        return new Error("Please provide what to do with the numbers!");
    }
}

package com.greenfox.rest.models;

import org.springframework.stereotype.Component;

@Component
public class DoUntil {
    private Long result;

    public DoUntil() {
    }

    public DoUntil( String input) {
        if (input.equals("sum")){
            this.result = 0L;
        }
        else if (input.equals("factor")){
            this.result = 1L;
        }

    }

    public void setResult(Until until, String input) {
        if (input.equals("sum")){
            for (int i = 0; i <= until.getUntil() ; i++) {
                this.result += i;
            }
        }
        else if (input.equals("factor")){
            for (int i = 1; i <= until.getUntil() ; i++) {
                this.result *= i;
            }
        }

    }

    public Long getResult() {
        return result;
    }
}

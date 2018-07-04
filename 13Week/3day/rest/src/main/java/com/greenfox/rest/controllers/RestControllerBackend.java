package com.greenfox.rest.controllers;

import com.greenfox.rest.models.*;
import com.greenfox.rest.models.Error;
import com.greenfox.rest.services.RestService;
import com.greenfox.rest.services.RestServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestControllerBackend {

    private final RestServiceImpl service;

    public RestControllerBackend ( RestServiceImpl service) {
        this.service=service;
    }

    @GetMapping("doubling")
    public Object getDouble(@RequestParam(required = false) Integer input){
        if (input == null){
            return new Error("Please provide an input!");
        }
        else{
            return new Result(input);
        }
    }

    @GetMapping("/greeter")
    public Object getGreeter(@RequestParam(required = false) String name, @RequestParam(required = false) String title){
        if (name == null ){
            return new Error("Please provide a name!");
        }
        else if (title == null){
            return new Error("Please provide a title!");
        }
        else{
            return new Greeter(name, title);
        }
    }

    @GetMapping("/appenda/{appendable}")
    public Object getGreeter(@PathVariable(required = false) String appendable){
        if (appendable == null ){
            return "/anotherendpoint";
        }
        else{
            return new AppendA(appendable);
        }
    }


    @PostMapping("/dountil/{what}")
    public Object doUntilGenarator(@RequestBody(required = false) Until until, @PathVariable("what") String what){
        if (until == null){
            return new Error("Please provide a number!");
        }
        else{
            DoUntil doUntil = new DoUntil(what);
            doUntil.setResult(until, what);
            return doUntil;
        }

    }

    @PostMapping("/arrays")
    public Object arrays( @RequestBody(required = false) InputArray input){
        if ( input == null){
            return new Error("Please provide what to do with the numbers!");
        }else{
            return service.doSomeMath(input.getWhat(), input.getNumbers());
        }
    }
}

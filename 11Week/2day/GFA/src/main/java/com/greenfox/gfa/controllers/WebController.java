package com.greenfox.gfa.controllers;

import com.greenfox.gfa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private StudentService studentservice;

    @GetMapping("/gfa")
    public String gfa(Model model) {
        model.addAttribute("number" ,studentservice.count());
        return "gfa";
    }

    @GetMapping("/gfa/list")
    public String listOfStudents(Model model) {
        model.addAttribute("students" , studentservice.findAll());
        return "list";
    }

    @GetMapping("/gfa/add")
    public String addStudents() {
        return "add";
    }

    @PostMapping("gfa/save")
    public String saveNewStudent(@ModelAttribute(value="name") String name){
        studentservice.save(name);
        return "redirect:/gfa/list";
    }

    @GetMapping("/gfa/checker")
    public String studentCheckerForm(){
        return "checker";
    }

    @PostMapping(value = "gfa/checker")
    public String isStudentIn(@RequestParam(value="name") String name, Model model){
        model.addAttribute("name",studentservice.checkStudent(name));
        return "checker";
    }

}

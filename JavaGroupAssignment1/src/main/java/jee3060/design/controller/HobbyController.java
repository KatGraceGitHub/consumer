package jee3060.design.controller;

import jee3060.design.model.Hobby;
import jee3060.design.repository.HobbyRep;
import jee3060.design.service.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/hobby")
public class HobbyController {
    @Autowired
    HobbyRep hobbyRep;

    @Autowired
    Producer producer;

    @GetMapping("/hobbies")
    public String showAllHobbies(Model model) {
        log.info(" GetMapping showAllInHobbies");
        model.addAttribute("hobbies", hobbyRep.findAll());
        return "hobbies";
    }


    @GetMapping("/update/{id}")
    public String editHobby(@PathVariable("id") int id, Model model) {
        log.info(" GetMapping editHobby");
        Hobby hobby = hobbyRep.findById(id).get();
        model.addAttribute("hobby", hobby);
        return "updateHobby";
    }

    @PostMapping("/update/{id}")
    public String updateHobby(@PathVariable("id") int id, @ModelAttribute("hobby") Hobby hobby, Model model) {
        log.info(" GetMapping editHobby");
        Hobby hobbyU = hobbyRep.findById(id).get();
        hobbyU.setHobbyId(hobby.getHobbyId());
        hobbyU.setHobbyDescription(hobby.getHobbyDescription());
        hobbyU.setHobbyCategory(hobby.getHobbyCategory());
        hobbyU.setHobbyName(hobby.getHobbyName());
        hobbyRep.save(hobbyU);
        model.addAttribute("hobby", hobby);
        return "redirect:/hobby/hobbies";
    }

    @GetMapping("/add")
    public String addHobby(Model model) {
        log.info(" GetMapping addHobby");
        Hobby hobby = new Hobby();
        //hobby.setHobbyId(hobbyRep.nextKey());
        model.addAttribute("hobby", hobby);
        return "addHobby";
    }

    @PostMapping("/add")
    public String addNewHobby(@ModelAttribute("") Hobby hobby) {
        log.info(" GetMapping addNewHobby");
        producer.sendMessage(hobby);
        hobbyRep.save(hobby);
        return "redirect:/hobby/hobbies";
    }

    @GetMapping("/delete/{id}")
    public String deleteHobby(@PathVariable("id") int id) {
        log.info(" GetMapping delete hobby");
        hobbyRep.deleteById(id);
        return "redirect:/hobby/hobbies";
    }

}

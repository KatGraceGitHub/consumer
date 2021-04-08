package jee3060.design.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${my.name}")
    private String name;

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("welcome", name);
        return "home";
    }
}

package com.example.thymeleaf.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerForRedirecting {
    @GetMapping("/")
    public String redirecting(Model model){
        return "redirect:/employees/list";
    }
}

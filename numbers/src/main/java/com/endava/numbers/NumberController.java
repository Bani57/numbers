package com.endava.numbers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@RestController
public class NumberController extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    @GetMapping("/")
    public String getNumber(NumberInput numberInput)
    {
        return "form";
    }
    @PostMapping("/")
    public String sendNumber(@Valid NumberInput numberInput, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "form";
        return "redirect:/results";
    }
}

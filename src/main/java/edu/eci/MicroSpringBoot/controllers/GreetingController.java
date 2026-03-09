package edu.eci.MicroSpringBoot.controllers;

import edu.eci.MicroSpringBoot.annotations.GetMapping;
import edu.eci.MicroSpringBoot.annotations.RequestParam;
import edu.eci.MicroSpringBoot.annotations.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(value="name", defaultValue="World") String name) {

        return "Hola " + name;
    }
}
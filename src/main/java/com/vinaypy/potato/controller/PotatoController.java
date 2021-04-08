package com.vinaypy.potato.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PotatoController {

    @PostMapping("elements")
    @ResponseStatus(HttpStatus.CREATED)
    public void addElements(){

    }

    @GetMapping("elements")
    public String getElements(){
        return "[{}]";
    }
}

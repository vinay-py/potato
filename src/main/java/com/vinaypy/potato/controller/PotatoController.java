package com.vinaypy.potato.controller;

import com.vinaypy.potato.model.ElementDto;
import com.vinaypy.potato.model.ElementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PotatoController {

    ElementService elementService;

    public PotatoController(ElementService elementService) {
        this.elementService = elementService;
    }

    @PostMapping("elements")
    @ResponseStatus(HttpStatus.CREATED)
    public void addElements(@RequestBody ElementDto elementDto){

        this.elementService.create(elementDto);
    }

    @GetMapping("elements")
    public List<ElementDto> getElements(){
//        return "[{'elementName':'element1'}]";
        return this.elementService.fetchAll();
    }
}

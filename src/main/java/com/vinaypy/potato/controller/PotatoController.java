package com.vinaypy.potato.controller;

import com.vinaypy.potato.model.ElementDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PotatoController {

    ArrayList<ElementDto> elementDtos;

    public PotatoController() {
        elementDtos = new ArrayList<ElementDto>();
    }

    @PostMapping("elements")
    @ResponseStatus(HttpStatus.CREATED)
    public void addElements(@RequestBody ElementDto elementDto){
        this.elementDtos.add(elementDto);
    }

    @GetMapping("elements")
    public List<ElementDto> getElements(){
//        return "[{'elementName':'element1'}]";
        return this.elementDtos;
    }
}

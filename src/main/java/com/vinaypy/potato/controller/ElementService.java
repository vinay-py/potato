package com.vinaypy.potato.controller;

import com.vinaypy.potato.model.ElementDto;
import com.vinaypy.potato.model.ElementEntity;
import com.vinaypy.potato.model.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElementService {

    private final ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void create(ElementDto elementDto) {
        elementRepository.save(
                new ElementEntity(elementDto.getElementName(),
                        elementDto.getElementType())
        );
    }
}

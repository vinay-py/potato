package com.vinaypy.potato.controller;

import com.vinaypy.potato.model.ElementDto;
import com.vinaypy.potato.model.ElementEntity;
import com.vinaypy.potato.model.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ElementDto> fetchAll() {
        return elementRepository.findAll()
                .stream()
                .map(elementEntity -> {
                    return new ElementDto(elementEntity.getElementName(), elementEntity.getElementType());
                })
                .collect(Collectors.toList());
    }
}

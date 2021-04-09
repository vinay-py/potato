package com.vinaypy.potato.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String elementName;
    String elementType;

    public ElementEntity(String elementName, String elementType) {
        this.elementName=elementName;
        this.elementType=elementType;
    }
}

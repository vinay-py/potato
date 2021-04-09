package com.vinaypy.potato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementDto {
    private String elementName;
    private String elementType;

}

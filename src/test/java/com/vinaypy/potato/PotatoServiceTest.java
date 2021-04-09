package com.vinaypy.potato;

import com.vinaypy.potato.controller.ElementService;
import com.vinaypy.potato.model.ElementDto;
import com.vinaypy.potato.model.ElementEntity;
import com.vinaypy.potato.model.ElementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PotatoServiceTest {

    @Mock
    ElementRepository mockElementRepository;

    @InjectMocks
    ElementService subject;

    @Test
    void create (){
        ElementDto elementDto = new ElementDto("element1","Book");
        subject.create(elementDto);
        verify(mockElementRepository).save(
                new ElementEntity("element1","Book")
        );

    }
}

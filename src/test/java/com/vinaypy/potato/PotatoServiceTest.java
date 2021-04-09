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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void fetchAll(){
        //S Setup
        ElementEntity elementEntity = new ElementEntity("element1","Book");
        when(mockElementRepository.findAll()).thenReturn(
                List.of(
                        elementEntity,
                        new ElementEntity("element2","Animal")
                )
        );

        //E Execute
        List<ElementDto> actual = subject.fetchAll();

        //A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new ElementDto("element1","Book"),
                        new ElementDto("element2","Animal")
                )
        );
    }
}

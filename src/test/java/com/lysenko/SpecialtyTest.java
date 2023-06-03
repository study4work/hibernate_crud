package com.lysenko;

import com.lysenko.controller.SpecialtyController;
import com.lysenko.entity.Specialty;
import com.lysenko.service.SpecialtyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SpecialtyTest {

    private final SpecialtyService specialtyService = mock(SpecialtyService.class);
    private final SpecialtyController specialtyController = new SpecialtyController(specialtyService);

    @Test
    public void createSpecialtyTest() {
        Specialty specialty = new Specialty();
        specialty.setDescriptionSpecialty("des");
        specialtyController.save(specialty);
        verify(specialtyService, times(1)).save(specialty);
    }
}

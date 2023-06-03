package com.lysenko;

import com.lysenko.controller.DeveloperController;
import com.lysenko.entity.Developer;
import com.lysenko.entity.Skill;
import com.lysenko.entity.Specialty;
import com.lysenko.service.DeveloperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperTest {

   private final DeveloperService developerService = mock(DeveloperService.class);
   private final DeveloperController developerController = new DeveloperController(developerService);

   @Test
   public void createDeveloperTest() {
      Developer developer = new Developer();
      developer.setFirstName("A");
      developer.setLastName("B");
      List<Skill> skills = mock(List.class);
      Specialty specialty = mock(Specialty.class);
      developer.setSkills(skills);
      developer.setSpecialty(specialty);
      developerController.save(developer);
      verify(developerService, times(1)).save(developer);
   }
}

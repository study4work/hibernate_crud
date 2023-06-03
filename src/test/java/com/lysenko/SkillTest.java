package com.lysenko;

import com.lysenko.controller.SkillController;
import com.lysenko.entity.Skill;
import com.lysenko.service.SkillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SkillTest {

    private final SkillService skillService = mock(SkillService.class);
    private final SkillController skillController = new SkillController(skillService);

    @Test
    public void createSkillTest() {
        Skill skill = new Skill();
        skill.setSkillDescription("desc");
        skillController.save(skill);
        verify(skillService, times(1)).save(any());
    }
}

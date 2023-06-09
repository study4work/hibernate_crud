package com.lysenko;

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

    private SkillService skillService = mock(SkillService.class);

    @Test
    public void createSkillTest() {
        Skill skill = new Skill();
        skill.setSkillDescription("desc");
        skillService.save(skill);
        verify(skillService, times(1)).save(any());
    }
}

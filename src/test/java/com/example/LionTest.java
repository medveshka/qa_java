package com.example;

import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void maleHasManeTest() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Грива у льва", lion.doesHaveMane());
    }

    @Test
    public void femaleHasNoManeTest() throws Exception {
        Lion lioness = new Lion("Самка", feline);
        Assert.assertFalse("У львицы гривы нет", lioness.doesHaveMane());
    }

    @Test
    public void whenWrongSexThrowExceptionTest() {
        try {
            Lion lion = new Lion("Null", feline);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void lionHasOneKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionEatsMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, lion.getFood());
    }
}
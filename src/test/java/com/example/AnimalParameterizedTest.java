package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final List<String> food;
    private final String animalKind;

    public AnimalParameterizedTest(List<String> food, String animalKind) {
        this.food = food;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters (name = "Список еды для животных {1}: {0}")
    public static Object[][] getFoodData() {
        return new Object[][]{
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
        };
    }

    @Test
    public void getFoodForAnimalKindTest() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(food, animal.getFood(animalKind));
    }
}
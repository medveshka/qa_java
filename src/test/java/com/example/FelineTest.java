package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
public class FelineTest {
    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, feline.eatMeat());
    }
    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void noParameterReturnOneKittensTest() {
        Feline feline = new Feline();
        int defaultKittensCount = 1;
        Assert.assertEquals(defaultKittensCount, feline.getKittens());
    }


}
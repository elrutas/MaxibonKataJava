package com.karumi.maxibonkata;


import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(JUnitQuickcheck.class) public class KarumiHQsProperties {

    private KarumiHQs karumiHQs;

    @Before public void setup() {
        Chat chat = mock(Chat.class);
        karumiHQs = new KarumiHQs(chat);
    }

    @Property public void fridgeAlwaysHas2OrMoreMaxibons(
            @From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property(trials = 10) public void fridgeAlwaysHas2OrMoreMaxibonsForKarumies(
            @From(KarumiesGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property(trials = 200) public void fridgeAlwaysHas2OrMoreMaxibons(
            List<@From(DevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property public void fridgeAlwaysHas2OrMoreMaxibonsWithHungryDevelopers(
            List<@From(HungryDevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property public void fridgeAlwaysHas2OrMoreMaxibonsWithNotSoHungryDevelopers(
            List<@From(NotSoHungryDevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }
}
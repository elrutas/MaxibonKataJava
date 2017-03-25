package com.karumi.maxibonkata;


import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class KarumiHQsProperties {

    private KarumiHQs karumiHQs;

    @Before public void setup() {
        karumiHQs = new KarumiHQs();
    }

    @Property public void fridgeAlwaysHas2OrMoreMaxibons(
            @From(DevelopersGenerator.class) Developer developer) {
//        System.out.println(developer);
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property public void fridgeAlwaysHas2OrMoreMaxibons(
            List<@From(DevelopersGenerator.class) Developer> developers) {
//        System.out.println(developer);
        karumiHQs.openFridge(developers);
        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }
}
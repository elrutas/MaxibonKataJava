package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {

    @Property public void maxibonsIsPositiveOrZero(int numberOfMaxibon) {
        Developer developer = new Developer("name", numberOfMaxibon);
//        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property public void maxibonsIsPositiveOrZeroForDevelopers(@From(DevelopersGenerator.class) Developer developer) {
//        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property public void maxibonsIsPositiveOrZeroForKarumies(@From(KarumiesGenerator.class) Developer developer) {
//        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property public void maxibonsIsPositiveOrZeroForNotSoHungry(
            @From(NotSoHungryDevelopersGenerator.class) Developer developer) {
//        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Test public void maxibonsAreTheExpectedNumber() {
        assertTrue(Karumies.ALBERTO.getNumberOfMaxibonsToGrab() == 1);
        assertTrue(Karumies.PEDRO.getNumberOfMaxibonsToGrab() == 3);
        assertTrue(Karumies.DAVIDE.getNumberOfMaxibonsToGrab() == 0);
        assertTrue(Karumies.JORGE.getNumberOfMaxibonsToGrab() == 1);
        assertTrue(Karumies.SERGIO.getNumberOfMaxibonsToGrab() == 2);
    }
}
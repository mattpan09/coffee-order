package edu.iu.habahram.coffeeorder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DarkRoastTest {

    @Test
    void darkRoastZeroCondiments() {
        DarkRoast darkRoast = new DarkRoast();
        assertEquals("Dark roast", darkRoast.getDescription());
        assertEquals(1.99F, darkRoast.cost());

        DarkRoast darkRoast2 = new DarkRoast();
        assertEquals("Dark roast", darkRoast2.getDescription());
        assertEquals(1.99F, darkRoast2.cost());
    }

    @Test
    void darkRoastOneCondiment() {
        DarkRoast darkRoast = new DarkRoast();
        Mocha mocha = new Mocha(darkRoast);
        assertEquals("Dark roast, Mocha", mocha.getDescription());
        assertEquals(2.29F, mocha.cost());

        DarkRoast darkRoast2 = new DarkRoast();
        Soy soy = new Soy(darkRoast2);
        assertEquals("Dark roast, Soy", soy.getDescription());
        assertEquals(2.26F, soy.cost());

        DarkRoast darkRoast3 = new DarkRoast();
        Whip whip = new Whip(darkRoast3);
        assertEquals("Dark roast, Whip", whip.getDescription());
        assertEquals(2.24F, whip.cost());

        DarkRoast darkRoast4 = new DarkRoast();
        Milk milk = new Milk(darkRoast4);
        assertEquals("Dark roast, Milk", milk.getDescription());
        assertEquals(2.39F, milk.cost());
    }

    @Test
    void darkRoastTwoCondiments() {
        DarkRoast darkRoast = new DarkRoast();
        Mocha mocha = new Mocha(darkRoast);
        Soy soy = new Soy(mocha);
        assertEquals("Dark roast, Mocha, Soy", soy.getDescription());
        assertEquals(2.56F, soy.cost());

        DarkRoast darkRoast2 = new DarkRoast();
        Mocha mocha2 = new Mocha(darkRoast2);
        Whip whip = new Whip(mocha2);
        assertEquals("Dark roast, Mocha, Whip", whip.getDescription());
        assertEquals(2.54F, whip.cost());
    }

    @Test
    void darkRoastThreeCondiments() {
        DarkRoast darkRoast = new DarkRoast();
        Mocha mocha = new Mocha(darkRoast);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        assertEquals("Dark roast, Mocha, Soy, Whip", whip.getDescription());
        assertEquals(2.81F, whip.cost());
    }

    @Test
    void darkRoastFourCondiments() {
        DarkRoast darkRoast = new DarkRoast();
        Mocha mocha = new Mocha(darkRoast);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        Milk milk = new Milk(whip);
        assertEquals("Dark roast, Mocha, Soy, Whip, Milk", milk.getDescription());
        assertEquals(3.21F, milk.cost());
    }
}

package edu.iu.habahram.coffeeorder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecafTest {

    @Test
    void decafZeroCondiments() {
        Decaf decaf = new Decaf();
        assertEquals("Decaf", decaf.getDescription());
        assertEquals(1.28F, decaf.cost());

        Decaf decaf2 = new Decaf();
        assertEquals("Decaf", decaf2.getDescription());
        assertEquals(1.28F, decaf2.cost());
    }

    @Test
    void decafOneCondiment() {
        Decaf decaf = new Decaf();
        Mocha mocha = new Mocha(decaf);
        assertEquals("Decaf, Mocha", mocha.getDescription());
        assertEquals(1.5799999F, mocha.cost());

        Decaf decaf2 = new Decaf();
        Soy soy = new Soy(decaf2);
        assertEquals("Decaf, Soy", soy.getDescription());
        assertEquals(1.55F, soy.cost());

        Decaf decaf3 = new Decaf();
        Whip whip = new Whip(decaf3);
        assertEquals("Decaf, Whip", whip.getDescription());
        assertEquals(1.53F, whip.cost());

        Decaf decaf4 = new Decaf();
        Milk milk = new Milk(decaf4);
        assertEquals("Decaf, Milk", milk.getDescription());
        assertEquals(1.68F, milk.cost());
    }

    @Test
    void decafTwoCondiments() {
        Decaf decaf = new Decaf();
        Mocha mocha = new Mocha(decaf);
        Soy soy = new Soy(mocha);
        assertEquals("Decaf, Mocha, Soy", soy.getDescription());
        assertEquals(1.8499999F, soy.cost());

        Decaf decaf2 = new Decaf();
        Mocha mocha2 = new Mocha(decaf2);
        Whip whip = new Whip(mocha2);
        assertEquals("Decaf, Mocha, Whip", whip.getDescription());
        assertEquals(1.8299999F, whip.cost());
    }

    @Test
    void decafThreeCondiments() {
        Decaf decaf = new Decaf();
        Mocha mocha = new Mocha(decaf);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        assertEquals("Decaf, Mocha, Soy, Whip", whip.getDescription());
        assertEquals(2.1F, whip.cost());
    }

    @Test
    void decafFourCondiments() {
        Decaf decaf = new Decaf();
        Mocha mocha = new Mocha(decaf);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        Milk milk = new Milk(whip);
        assertEquals("Decaf, Mocha, Soy, Whip, Milk", milk.getDescription());
        assertEquals(2.5F, milk.cost());
    }
}

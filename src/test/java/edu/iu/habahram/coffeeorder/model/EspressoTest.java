package edu.iu.habahram.coffeeorder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EspressoTest {

    @Test
    void espressoZeroCondiments() {
        Espresso espresso = new Espresso();
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(1.34F, espresso.cost());

        Espresso espresso2 = new Espresso();
        assertEquals("Espresso", espresso2.getDescription());
        assertEquals(1.34F, espresso2.cost());
    }

    @Test
    void espressoOneCondiment() {
        Espresso espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        assertEquals("Espresso, Mocha", mocha.getDescription());
        assertEquals(1.6400001F, mocha.cost());

        Espresso espresso2 = new Espresso();
        Soy soy = new Soy(espresso2);
        assertEquals("Espresso, Soy", soy.getDescription());
        assertEquals(1.61F, soy.cost());

        Espresso espresso3 = new Espresso();
        Whip whip = new Whip(espresso3);
        assertEquals("Espresso, Whip", whip.getDescription());
        assertEquals(1.59F, whip.cost());

        Espresso espresso4 = new Espresso();
        Milk milk = new Milk(espresso4);
        assertEquals("Espresso, Milk", milk.getDescription());
        assertEquals(1.74F, milk.cost());
    }

    @Test
    void espressoTwoCondiments() {
        Espresso espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        Soy soy = new Soy(mocha);
        assertEquals("Espresso, Mocha, Soy", soy.getDescription());
        assertEquals(1.9100001F, soy.cost());

        Espresso espresso2 = new Espresso();
        Mocha mocha2 = new Mocha(espresso2);
        Whip whip = new Whip(mocha2);
        assertEquals("Espresso, Mocha, Whip", whip.getDescription());
        assertEquals(1.8900001F, whip.cost());
    }

    @Test
    void espressoThreeCondiments() {
        Espresso espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        assertEquals("Espresso, Mocha, Soy, Whip", whip.getDescription());
        assertEquals(2.16F, whip.cost());
    }

    @Test
    void espressoFourCondiments() {
        Espresso espresso = new Espresso();
        Mocha mocha = new Mocha(espresso);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        Milk milk = new Milk(whip);
        assertEquals("Espresso, Mocha, Soy, Whip, Milk", milk.getDescription());
        assertEquals(2.5600002F, milk.cost());
    }
}

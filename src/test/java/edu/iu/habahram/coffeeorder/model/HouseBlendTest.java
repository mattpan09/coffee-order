package edu.iu.habahram.coffeeorder.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseBlendTest {
    //Floating points are handled in the front-end display
    @Test
    void houseBlendZeroCondiments() {
        HouseBlend houseBlend = new HouseBlend();
        assertEquals("House blend", houseBlend.getDescription());
        assertEquals(1.65F, houseBlend.cost());

        HouseBlend houseBlend2 = new HouseBlend();
        assertEquals("House blend", houseBlend2.getDescription());
        assertEquals(1.65F, houseBlend2.cost());
    }

    @Test
    void houseBlendOneCondiment() {
        HouseBlend houseBlend = new HouseBlend();
        Mocha mocha = new Mocha(houseBlend);
        assertEquals("House blend, Mocha", mocha.getDescription());
        assertEquals(1.95F, mocha.cost());

        HouseBlend houseBlend2 = new HouseBlend();
        Soy soy = new Soy(houseBlend2);
        assertEquals("House blend, Soy", soy.getDescription());
        assertEquals(1.92F, soy.cost());

        HouseBlend houseBlend3 = new HouseBlend();
        Whip whip = new Whip(houseBlend3);
        assertEquals("House blend, Whip", whip.getDescription());
        assertEquals(1.9F, whip.cost());

        HouseBlend houseBlend4 = new HouseBlend();
        Milk milk = new Milk(houseBlend4);
        assertEquals("House blend, Milk", milk.getDescription());
        assertEquals(2.05F, milk.cost());
    }

    @Test
    void houseBlendTwoCondiments() {
        HouseBlend houseBlend = new HouseBlend();
        Mocha mocha = new Mocha(houseBlend);
        Soy soy = new Soy(mocha);
        assertEquals("House blend, Mocha, Soy", soy.getDescription());
        assertEquals(2.22F, soy.cost());

        HouseBlend houseBlend2 = new HouseBlend();
        Mocha mocha2 = new Mocha(houseBlend2);
        Whip whip = new Whip(mocha2);
        assertEquals("House blend, Mocha, Whip", whip.getDescription());
        assertEquals(2.2F, whip.cost());
    }

    @Test
    void houseBlendThreeCondiments() {
        HouseBlend houseBlend = new HouseBlend();
        Mocha mocha = new Mocha(houseBlend);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        assertEquals("House blend, Mocha, Soy, Whip", whip.getDescription());
        assertEquals(2.47F, whip.cost());
    }

    @Test
    void houseBlendFourCondiments() {
        HouseBlend houseBlend = new HouseBlend();
        Mocha mocha = new Mocha(houseBlend);
        Soy soy = new Soy(mocha);
        Whip whip = new Whip(soy);
        Milk milk = new Milk(whip);
        assertEquals("House blend, Mocha, Soy, Whip, Milk", milk.getDescription());
        assertEquals(2.8700001F, milk.cost());
    }
}

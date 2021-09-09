package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Race;

class RaceFactoryTest {

    @Test
    void createRace() {
        Race race = RaceFactory.createRace("Indian");
        System.out.println();
    }


}
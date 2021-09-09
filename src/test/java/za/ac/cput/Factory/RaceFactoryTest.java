package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Race;

import static org.junit.jupiter.api.Assertions.*;

class RaceFactoryTest {

    @Test
    void createRace() {
        Race race = RaceFactory.createRace("Indian");
        assertNotNull(race.getDesc(), race.getId());
        System.out.println("Race :"+ race) ;
    }


}
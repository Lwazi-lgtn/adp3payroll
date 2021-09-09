package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Race;
import za.ac.cput.Factory.RaceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class RaceServiceTest {
   private static RaceService service = RaceService.getRaceService();
   private static Race race = RaceFactory.createRace("Indian");

    @Test
    void a_create() {
     Race created = service.create(race);
    // assertNotNull(created);
     assertEquals(created.getId(),race.getId());
     System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
    Race read = service.read(race.getId());
    assertEquals(read.getId(),race.getId());
    System.out.println("Read: " + read );
    }

    @Test
    void c_update() {
     Race updated = new Race.Builder().copy(race).setDesc("Indian").build();
     assertNotNull(service.update(updated));
     System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
     boolean success = service.delete((String) race.getId());
     assertTrue(success);
     System.out.println("Delete: "+ success);
    }

    @Test
    void d_getAll() {
     System.out.println("Show All: ");
     System.out.println(service.getAll());
    }
}
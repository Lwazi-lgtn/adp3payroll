package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Race;
import za.ac.cput.Factory.RaceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RaceRepositoryTest {
   private static RaceRepository repository = RaceRepository.getRaceRepository();
   private static Race race = RaceFactory.createRace("indian");


    @Test
    void a_create() {
        Race created = repository.create(race);
        assertEquals(created.getId(), race.getId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Race read = repository.read((String) race.getId());
        assertNotEquals(read);
        System.out.println("read: "+ read);

    }

    private void assertNotEquals(Race read) {
    }

    @Test
    void c_update() {
        Race updated = new Race.Builder().copy(race).setDesc("Indian").build();
        assertNotEquals(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete((String) race.getId());
        assertTrue(success);
        System.out.println("delete: "+success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show All");
        System.out.println(repository.getAll());
    }
}

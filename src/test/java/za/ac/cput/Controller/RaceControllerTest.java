package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Race;
import za.ac.cput.Factory.RaceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class) //in order for tests to run alphabetically
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class RaceControllerTest {

    private static Race race = RaceFactory.createRace("Indian");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL ="http://localhost:8080/race";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Race> postResponse = restTemplate.postForEntity(url,race,Race.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        race = postResponse.getBody();
        System.out.println("Saved data: " + race);
        assertEquals(race.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + race.getId();
        System.out.println("URL "+ url);
        ResponseEntity<Race> response = restTemplate.getForEntity(url,Race.class);
        assertEquals(race.getId(), response.getBody().getId());
    }

    @Test
    void c_update() {
        Race updated = new Race.Builder().copy(race).setDesc("Indian").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+ updated);
        ResponseEntity<Race> response = restTemplate.postForEntity(url,updated,Race.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + race.getId();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL");
        System.out.println(response);
    }
}
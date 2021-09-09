package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Race;
import za.ac.cput.Factory.RaceFactory;
import za.ac.cput.Service.RaceService;

import java.util.Set;

@SpringBootApplication
@RestController
@RequestMapping("/race")
public class RaceController {
     @Autowired
    private RaceService raceService;
   // @RequestMapping(value = "/create", method = RequestMethod.POST)

    @PostMapping("/create")
    public Race create(@RequestBody Race race){
        Race newRace = RaceFactory.createRace(race.getDesc());
        return raceService.create(newRace);
    }

    @GetMapping("/read{id}")
    public Race read(@PathVariable String id){
        return raceService.read(id);
    }

    @PostMapping("/update")
    public Race update(@RequestBody Race race){return raceService.update(race);}

    @PostMapping("/delete{id}")
    public boolean delete(@PathVariable String id){return raceService.delete(id);}

    @GetMapping("/getall")
    public Set<Race> getAll(){ return raceService.getAll();
    }
    @GetMapping("/getallwitha")
    public  Set<Race> getallwitha(){      //call races start with A
        return raceService.getAllRacesStartWithA();
    }
}

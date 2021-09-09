/*
SubjectService.java
Tomson Lwazi (218204493)
14 Aug 2021

 */
package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Race;
import za.ac.cput.Repository.RaceRepository;


import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
public class RaceService implements IRaceService{

    private static RaceService raceService = null;
    private RaceRepository raceRepository;

    private RaceService(){
        this.raceRepository= RaceRepository.getRaceRepository();
    }

    public static RaceService getRaceService(){
        if(raceService==null){
            raceService = new RaceService();
        }
        return raceService;
    }


    @Override
    public Race create(Race race) {
        return this.raceRepository.create(race);
    }

    @Override
    public Race read(String raceId) {
        return this.raceRepository.read(raceId);
    }

    @Override
    public Race update(Race race) {
        return this.raceRepository.update(race);
    }

    @Override
    public boolean delete(String raceId) {
        return this.raceRepository.delete(raceId);
    }

    @Override
    public Set<Race> getAll() {
        return this.raceRepository.getAll();
    }

    public Set<Race> getAllRacesStartWithA(){      //Service that returns all races that start with A
        Set<Race> racesWithA = new HashSet<Race>();    //grant access to it in RaceController
        Set<Race>  races = getAll();
        for (Race race : races){
            if(race.getDesc().trim().toLowerCase().startsWith("a"));{
                racesWithA.add(race);
            }
        }
        return racesWithA;
    }
}

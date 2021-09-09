/* SubjectRepository.java
    Author: Lwazi Tomson (218204493)
    Date: 25 July 2021
 */

package za.ac.cput.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Race;
import java.util.HashSet;
import java.util.Set;

@Service
public class RaceRepository implements IRaceRepository{

    private static RaceRepository raceRepository = null;
    private Set<Race> raceDB = null;

    private RaceRepository(){
        raceDB = new HashSet<Race>();
    }

    public static RaceRepository getRaceRepository(){ //Singleton pattern
        if(raceRepository == null){
            raceRepository = new RaceRepository();
        }
        return raceRepository;
    }

    @Override
    public Race create(Race race) {
       raceDB.add(race);
        return race;
    }

    @Override
    public Race read(String id) {

        //using lamba expression
            Race race= raceDB.stream()
                    .filter(r -> r.getId().equals(id))
                    .findAny()
                    .orElse(null);
            return race;
    }

    @Override
    public Race update(Race race ) {
        Race race1 = read((String) race.getId());
        if (race1 != null){
            raceDB.remove(race1);
            raceDB.add(race);
            return race;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Race raceToDelete = read(id);
        if (raceToDelete == null) {
            return false;
        }
        raceDB.remove(raceToDelete);
        return true;
    }
    @Override
    public Set<Race> getAll() { return raceDB;}

}

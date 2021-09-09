/* Student-Marks-Project.java
 Entity for the Subject
 Author: Lwazi Tomson (218204493)
 Date: 9 June 2021
 */

package za.ac.cput.Factory;
import za.ac.cput.Entity.Race;
import za.ac.cput.Util.GenericHelper;

public class RaceFactory {

public  static Race createRace(String desc){
    String id = GenericHelper.generateId();
    Race race = new Race.Builder().setId(id)
            .setDesc(desc)
            .build();
    return race;
}

    public static Race build(Object id, Object desc) {

        return null;
    }

}

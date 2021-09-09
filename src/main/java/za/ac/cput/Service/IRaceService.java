/* ISubjectService.java
    Tomson Lwazi (218204493)
    Date: 14 Aug 2021
 */
package za.ac.cput.Service;

import za.ac.cput.Entity.Race;

import java.util.Set;

public interface IRaceService extends IService<Race, String>{
    Set<Race> getAll();
}

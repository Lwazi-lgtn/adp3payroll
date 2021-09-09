/*
    Repository for the User.
    Author: Lwazi Tomson (218204493)
    Date: 25 July 2021
 */


package za.ac.cput.Repository;

import za.ac.cput.Entity.Race;

import java.util.Set;

public interface IRaceRepository extends IRepository<Race, String> {
    public Set<Race> getAll();
}

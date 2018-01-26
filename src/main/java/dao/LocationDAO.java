package dao;

import models.*;
import java.util.List;

/**
 * Created by Guest on 1/26/18.
 */
public interface LocationDAO {
    //CREATE
    void add (Location location);

    //READ
    Location findById(int id);
    List<Location> findAll();

    //UPDATE
    void updateLocation (String location, String description);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

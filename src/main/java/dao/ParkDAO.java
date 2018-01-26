package dao;

import models.*;
import java.util.List;

/**
 * Created by Guest on 1/26/18.
 */
public interface ParkDAO {
    //CREATE
    void add (Park park);

    //READ
    Park findById(int id);
    List<Park> findAll();

    //UPDATE
    void updatePark (String park, String description, int locationId);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

package dao;
import models.*;
import org.sql2o.Sql2o;
import java.util.List;

public class ParkSQL implements ParkDAO {

    private final Sql2o sql2o;
    public ParkSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void add(Park park) {

    }

    /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public Park getById(int id) {
        return null;
    }

    @Override
    public List<Park> getAll() {
        return null;
    }

    /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void updatePark(String park, String description, int locationId) {

    }

    /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

}

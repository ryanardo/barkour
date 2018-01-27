package dao;
import models.*;
import org.sql2o.Sql2o;
import java.util.List;

public class LocationSQL implements LocationDAO {

    private final Sql2o sql2o;
    public LocationSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void add(Location location) {

    }

    /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public Location getById(int id) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return null;
    }

    /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void updateLocation(String location, String description) {

    }

    /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

}

package dao;

import models.Location;
import models.Park;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by Guest on 1/26/18.
 */
public class ParkSQLTest {

    private LocationDAO daoLocation;
    private ParkDAO daoPark;
    private ReviewDAO daoReview;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        daoLocation = new LocationSQL(sql2o);
        daoPark = new ParkSQL(sql2o);
        daoReview = new ReviewSQL(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_canCreatePark_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        int idLocation1 = location1.getId();
        daoLocation.add(location1);

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);

        assertEquals(1, daoPark.getAll().size());
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void updatePark() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}
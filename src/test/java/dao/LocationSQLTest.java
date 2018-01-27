package dao;

import models.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;

public class LocationSQLTest {

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
    public void add_createLocationInstance_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        assertEquals(true, location1 instanceof Location);
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void updateLocation() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}
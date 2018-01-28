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
    public void add_canCreateLocation_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        assertEquals(1, daoLocation.getAll().size());
    }

    @Test
    public void findById_canFindLocationById_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        Location location2 = new Location("1000 Acres", "Absolutely enormous off-leash dog park.");
        daoLocation.add(location2);

        assertEquals("Sandy River Delta", daoLocation.getById(1).getLocation());
    }

    @Test
    public void findAll_canFindAllLocations_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        Location location2 = new Location("1000 Acres", "Absolutely enormous off-leash dog park.");
        daoLocation.add(location2);

        assertEquals(2, daoLocation.getAll().size());
    }

    @Test
    public void updateLocation_canUpdateLocation_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        int idUpdatedLocation = location1.getId();
        daoLocation.updateLocation(idUpdatedLocation, "1000 Acres", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");

        assertEquals("1000 Acres", daoLocation.getById(idUpdatedLocation).getLocation());
    }

    @Test
    public void deleteById_canDeleteLocationById_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        Location location2 = new Location("1000 Acres", "Absolutely enormous off-leash dog park.");
        daoLocation.add(location2);

        int idDeletedLocation = location1.getId();
        daoLocation.deleteById(idDeletedLocation);

        assertEquals(1, daoLocation.getAll().size());
    }

    @Test
    public void deleteAll() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);

        Location location2 = new Location("1000 Acres", "Absolutely enormous off-leash dog park.");
        daoLocation.add(location2);

        daoLocation.deleteAll();

        assertEquals(0, daoLocation.getAll().size());
    }

}
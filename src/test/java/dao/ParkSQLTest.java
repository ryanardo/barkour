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
    public void findById_canFindParkById_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        assertEquals("1000 Acres", daoPark.getById(idPark1).getPark());
    }

    @Test
    public void findAll_canFindAllParks_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Location location2 = new Location("PDX", "The City of Portland, found in the State of Oregon.");
        daoLocation.add(location2);
        int idLocation2 = location2.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        Park park2 = new Park("Hazelia Field", "\n" +
                "The Hazelia Dog  Park, located at Hazelia Field at Luscher Farm, 17800 Stafford Road  is separated into two areas for our canine friends.\n" +
                "\n" +
                "The northern most area is for timid and shy dogs. The larger area fronting the parking lot is for more outgoing dogs. See the attached PDF under Supporting Documents for more information.", idLocation2);
        daoPark.add(park2);
        int idPark2 = park2.getId();

        assertEquals(2, daoPark.getAll().size());
    }

    @Test
    public void updatePark_canUpdatePark_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        daoPark.updatePark("1000 Acres", "Dog Park located in the Sandy River Delta.", idPark1);

        assertEquals("Dog Park located in the Sandy River Delta.", daoPark.getById(idPark1).getDescription());
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}
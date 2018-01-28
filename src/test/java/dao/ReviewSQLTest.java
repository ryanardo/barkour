package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static junit.framework.TestCase.assertEquals;

public class ReviewSQLTest {

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
    public void add_canCreateReview_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        Review review1 = new Review("Awesome!", "Great dog park, absolutely LOVELY!",8, idPark1);
        daoReview.add(review1);

        assertEquals(1, daoLocation.getAll().size());
    }

    @Test
    public void findById_canFindParkById_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        Review review1 = new Review("Awesome!", "Great dog park, absolutely LOVELY!",8, idPark1);
        daoReview.add(review1);
        int idReview1 = review1.getId();

        Review review2 = new Review("¯\\_(ツ)_/¯", "It's alright, could be better.",5, idPark1);
        daoReview.add(review2);
        int idReview2 = review2.getId();

        assertEquals(5, daoReview.getById(idReview2).getRating());
    }

    @Test
    public void findAll_canFindAllReviews_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        Review review1 = new Review("Awesome!", "Great dog park, absolutely LOVELY!",8, idPark1);
        daoReview.add(review1);
        int idReview1 = review1.getId();

        Review review2 = new Review("¯\\_(ツ)_/¯", "It's alright, could be better.",5, idPark1);
        daoReview.add(review2);
        int idReview2 = review2.getId();

        assertEquals(2, daoReview.getAll().size());
    }

    @Test
    public void updateReview_canUpdateReview_true() throws Exception {
        Location location1 = new Location("Sandy River Delta", "Gigantic, off leash dog park, with beautiful, wide open expanses for you and your pup.");
        daoLocation.add(location1);
        int idLocation1 = location1.getId();

        Park park1 = new Park("1000 Acres", "Dog Park located in the Sandy River Delta (not actually 1000 acres).", idLocation1);
        daoPark.add(park1);
        int idPark1 = park1.getId();

        Review review1 = new Review("Awesome!", "Great dog park, absolutely LOVELY!",8, idPark1);
        daoReview.add(review1);
        int idReview1 = review1.getId();

        daoReview.updateReview(idReview1, "Awesome!", "Great dog park, absolutely LOVELY!",10, idPark1);

        assertEquals(10, daoReview.getById(idReview1).getRating());
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}
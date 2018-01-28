package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 * Created by Guest on 1/26/18.
 */
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
    public void add() throws Exception {
    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void updateReview() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteAll() throws Exception {
    }

}
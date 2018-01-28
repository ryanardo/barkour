import dao.*;
import models.*;
import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.Gson;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String connectionString = "jdbc:h2:~/barkore.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        Connection conn;
        Gson gson = new Gson();
        LocationSQL daoLocation;
        ParkSQL daoPark;
        ReviewSQL daoReview;

        daoLocation = new LocationSQL(sql2o);
        daoPark = new ParkSQL(sql2o);
        daoReview = new ReviewSQL(sql2o);
        conn = sql2o.open();

        /* STATIC * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //delete all locations

        //delete all parks

        //delete all reviews

        /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //create a new location


        //create a new park


        //create a new review

        /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //read a location


        //read a park


        //read a review

        /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //update a location


        //update a park


        //update a review

        /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //delete a location

        //delete a park

        //delete a review

    } //end of 'psvm'
} //end of 'App.java'

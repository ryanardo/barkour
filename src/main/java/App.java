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
        post("/locations/new", "application/json", (request, response) -> {
            Location location = gson.fromJson(request.body(), Location.class); //convert GSON to JSON
            daoLocation.add(location); //run our dao methods
            response.status(201);
            response.type("application/json");
            return gson.toJson(location); //convert JSON to GSON
        });

        //create a new park
        post("/locations/:location_id/parks?:park_id/new", "application/json", ((request, response) -> {
            Park park = gson.fromJson(request.body(), Park.class);
            daoPark.add(park);
            response.status(201);
            response.type("application/json");
            return gson.toJson(park);
        }));

        //create a new review
        post("/locations/:location_id/parks?:park_id/reviews/:review_id/new", "application/json", ((request, response) -> {
          Review review = gson.fromJson(request.body(), Review.class);
          daoReview.add(review);
          response.status(201);
          response.type("application/json");
          return gson.toJson(review);
        }));


        /* READ * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //get a location
        get("/locations", "application/json", ((request, response) -> {
          if (daoLocation.getAll().size() > 0) {
            return gson.toJson(daoLocation.getAll());
          } else {
            return "{\"message\":\"I'm sorry, but no Locations are currently listed within the database.\"}";
          }

        }));

        //get a park
        //get("/locations/:location_id/parks/:park_id", "application/json", ((request, response) -> {}));

        //get a review
        //get("/locations/:location_id/parks/:park_id/reviews/:review_id", "application/json", ((request, response) -> {}));

        //get all locations
        //get("/locations", "application/json", ((request, response) -> {}));

        //get all parks
        //get("/locations/:location_id/parks", "application/json", ((request, response) -> {}));

        //get all reviews
        //get("/locations/:location_id/parks/:park_id/reviews", "application/json", ((request, response) -> {}));

        /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //update a location
        //post("/locations/new", "application/json", ((request, response) -> {}));

        //update a park
        //post("/locations/:location_id/parks/:park_id/new", "application/json", ((request, response) -> {}));

        //update a review
        //post("/locations/:location_id/parks/:park_id/reviews/:review_id/new", "application/json", ((request, response) -> {}));

        /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //delete a location


        //delete a park


        //delete a review


    } //end of 'psvm'
} //end of 'App.java'

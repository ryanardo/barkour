package dao;

import models.*;
import java.util.List;

/**
 * Created by Guest on 1/26/18.
 */
public interface ReviewDAO {
    //CREATE
    void add (Review review);

    //READ
    Review findById(int id);
    List<Review> findAll();

    //UPDATE
    void updateReview (String title, String review, int rating, int parkId);

    //DELETE
    void deleteById(int id);
    void deleteAll();
}

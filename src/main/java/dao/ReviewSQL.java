package dao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class ReviewSQL implements ReviewDAO {

    private final Sql2o sql2o;
    public ReviewSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void add(Review review) {
        String sql = "INSERT INTO reviews (title, review, rating, parkId) VALUES (:title, :review, :rating, :parkId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(review)
                    .executeUpdate()
                    .getKey();
            review.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public Review getById(int id) {
        String sql = "SELECT * FROM reviews WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Review.class);
        }
    }

    @Override
    public List<Review> getAll() {
        String sql = "SELECT * FROM reviews";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Review.class);
        }
    }

    /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void updateReview(int id, String title, String review, int rating, int parkId) {
        String sql = "UPDATE reviews SET title = :title, review = :review, rating = :rating, parkId = :parkId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("title", title)
                    .addParameter("review", review)
                    .addParameter("rating", rating)
                    .addParameter("parkId", parkId)
                    .executeUpdate();
        }
    }

    /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM reviews WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM reviews";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}

package dao;
import models.*;
import org.sql2o.Sql2o;
import java.util.List;

public class ReviewSQL implements ReviewDAO {

    private final Sql2o sql2o;
    public ReviewSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void add(Review review) {

    }

    /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public Review getById(int id) {
        return null;
    }

    @Override
    public List<Review> getAll() {
        return null;
    }

    /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void updateReview(String title, String review, int rating, int parkId) {

    }

    /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

}

package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class ParkSQL implements ParkDAO {

    private final Sql2o sql2o;
    public ParkSQL(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /* CREATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void add(Park park) {
        String sql = "INSERT INTO parks (park, description, locationId) VALUES (:park, :description, :locationId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(park)
                    .executeUpdate()
                    .getKey();
            park.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    /* REVIEW * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public Park getById(int id) {
        String sql = "SELECT * FROM parks WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Park.class);
        }
    }

    @Override
    public List<Park> getAll() {
        String sql = "SELECT * FROM parks";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Park.class);
        }
    }

    /* UPDATE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void updatePark(String park, String description, int locationId) {
        String sql = "UPDATE parks SET park = :park, description = :description WHERE locationId = :locationId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("park", park)
                    .addParameter("description", description)
                    .addParameter("id", locationId)
                    .executeUpdate();
        }
    }

    /* DELETE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM parks WHERE id = :id";
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
        String sql = "DELETE FROM parks";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}

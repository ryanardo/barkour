package models;

/**
 * Created by Guest on 1/26/18.
 */
public class Location {

    private int id;
    private String location;
    private String description;

/* CONSTRUCTORS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public Location(String location, String description) {
        this.location = location;
        this.description = description;
    }

/* GETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

/* SETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/* HASH CODE & EQUALS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location1 = (Location) o;

        if (id != location1.id) return false;
        if (!location.equals(location1.location)) return false;
        return description != null ? description.equals(location1.description) : location1.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + location.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

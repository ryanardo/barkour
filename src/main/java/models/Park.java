package models;

/**
 * Created by Guest on 1/26/18.
 */
public class Park {

    private int id;
    private String park;
    private String description;
    private int locationId;

/* CONSTRUCTORS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public Park(String park, String description, int locationId) {
        this.park = park;
        this.description = description;
        this.locationId = locationId;
    }

/* GETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public int getId() {
        return id;
    }

    public String getPark() {
        return park;
    }

    public String getDescription() {
        return description;
    }

    public int getLocationId() {
        return locationId;
    }

/* SETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public void setId(int id) {
        this.id = id;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

/* HASH CODE & EQUALS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Park park1 = (Park) o;

        if (id != park1.id) return false;
        if (locationId != park1.locationId) return false;
        if (!park.equals(park1.park)) return false;
        return description != null ? description.equals(park1.description) : park1.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + park.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + locationId;
        return result;
    }
}

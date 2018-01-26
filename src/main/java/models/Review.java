package models;

/**
 * Created by Guest on 1/26/18.
 */
public class Review {

    private int id;
    private String title;
    private String review;
    private int rating;
    private int parkId;

/* CONSTRUCTORS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public Review(String title, String review, int rating, int parkId) {
        this.title = title;
        this.review = review;
        this.rating = rating;
        this.parkId = parkId;
    }

/* GETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public int getParkId() {
        return parkId;
    }

/* SETTERS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

/* HASH CODE & EQUALS * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review1 = (Review) o;

        if (id != review1.id) return false;
        if (rating != review1.rating) return false;
        if (parkId != review1.parkId) return false;
        if (!title.equals(review1.title)) return false;
        return review != null ? review.equals(review1.review) : review1.review == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + parkId;
        return result;
    }
}
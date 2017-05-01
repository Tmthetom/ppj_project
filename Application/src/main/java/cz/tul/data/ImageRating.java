package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Image_Rating")
@IdClass(ImageRatingId.class)
public class ImageRating implements Serializable {

    @Id
    @Column(name="id_image")
    private int id_image;

    @Id
    @Column(name="id_user")
    private int id_user;

    @Column(name="rating")
    private boolean rating;

    public ImageRating() {
        ;
    }

    public ImageRating(int id_image, int id_user, boolean rating) {
        this.id_image = id_image;
        this.id_user = id_user;
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Image_Rating{" +
                "id_image = " + id_image + ", " +
                "id_user = " + id_user + ", " +
                "rating = " + rating +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageRating image_rating = (ImageRating) object;

        if (id_image != image_rating.getId_image()) return false;
        if (id_user != image_rating.getId_user()) return false;
        if (rating != image_rating.getRating()) return false;
        return true;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean getRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}

package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Comment_Rating")
@IdClass(CommentRatingId.class)
public class CommentRating implements Serializable {

    @Id
    @Column(name="id_comment")
    private int id_comment;

    @Id
    @Column(name="id_user")
    private int id_user;

    @Column(name="rating")
    private boolean rating;

    public CommentRating() {
        ;
    }

    public CommentRating(int id_comment, int id_user, boolean rating) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Comment_Rating{" +
                "id_comment = " + id_comment + ", " +
                "id_user = " + id_user + ", " +
                "rating = " + rating +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CommentRating image = (CommentRating) object;

        if (id_comment != image.getId_comment()) return false;
        if (id_user != image.getId_user()) return false;
        if (rating != image.getRating()) return false;
        return true;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
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

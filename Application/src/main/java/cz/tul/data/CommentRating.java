package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Comment_Rating")
@IdClass(CommentRatingId.class)
public class CommentRating implements Serializable {

    @Id
    @Column(name="id_comment")
    private int idComment;

    @Id
    @Column(name="id_user")
    private int id_user;

    @Column(name="rating")
    private boolean rating;

    public CommentRating() {
        ;
    }

    public CommentRating(int idComment, int id_user, boolean rating) {
        this.idComment = idComment;
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
                "idComment = " + idComment + ", " +
                "id_user = " + id_user + ", " +
                "rating = " + rating +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CommentRating image = (CommentRating) object;

        if (idComment != image.getIdComment()) return false;
        if (id_user != image.getId_user()) return false;
        if (rating != image.getRating()) return false;
        return true;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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

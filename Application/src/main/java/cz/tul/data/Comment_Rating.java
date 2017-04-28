package cz.tul.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Comment_Rating")
public class Comment_Rating {

    @Id
    @Column(name="id_comment")
    private int id_comment;

    //@Id
    @Column(name="id_user")
    private int id_user;

    @Column(name="rating")
    private boolean rating;

    public Comment_Rating() {
        ;
    }

    public Comment_Rating(int id_comment, int id_user, boolean rating) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.rating = rating;
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
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Comment_Rating temp = (Comment_Rating)obj;
        if (getId_comment() != temp.getId_comment()) {
            return false;
        }
        if (getId_user() != temp.getId_user()) {
            return false;
        }
        if (getRating() != temp.getRating()) {
            return false;
        }
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

package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Comment_Rating")
public class Comment_Rating implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="id_comment")
    private Comment comment;

    @Id
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @Column(name="rating")
    private boolean rating;

    public Comment_Rating() {
        ;
    }

    public Comment_Rating(Comment comment, User user, boolean rating) {
        this.comment = comment;
        this.user = user;
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Comment_Rating{" +
                "comment = " + comment + ", " +
                "user = " + user + ", " +
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
        if (!getComment().equals(temp.getComment())) {
            return false;
        }
        if (!getUser().equals(temp.getUser())) {
            return false;
        }
        if (getRating() != temp.getRating()) {
            return false;
        }
        return true;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}

package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Image_Rating")
public class Image_Rating implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="id_image")
    private Image image;

    @Id
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @Column(name="rating")
    private boolean rating;

    public Image_Rating() {
        ;
    }

    public Image_Rating(Image image, User user, boolean rating) {
        this.image = image;
        this.user = user;
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Image_Rating{" +
                "image = " + image + ", " +
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
        Image_Rating temp = (Image_Rating)obj;
        if (!getImage().equals(temp.getImage())) {
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

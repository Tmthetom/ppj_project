package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Image_Tag")
public class Image_Tag implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="id_image")
    private Image image;

    @Id
    @ManyToOne
    @JoinColumn(name="name")
    private Tag tag;

    public Image_Tag() {
        ;
    }

    public Image_Tag(Image Image, Tag tag) {
        this.image = Image;
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Image_Tag{" +
                "image = " + image + ", " +
                "tag = " + tag +
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
        Image_Tag temp = (Image_Tag)obj;
        if (!getImage().equals(getImage())) {
            return false;
        }
        if (!getTag().equals(temp.getTag())) {
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

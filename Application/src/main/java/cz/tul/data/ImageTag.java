package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Image_Tag")
@IdClass(ImageTagId.class)
public class ImageTag implements Serializable {

    @Id
    @Column(name="id_image")
    private int id_image;

    @Id
    @Column(name="name")
    private String name;

    public ImageTag() {
        ;
    }

    public ImageTag(int id_image, String name) {
        this.id_image = id_image;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Image_Tag{" +
                "id_image = " + id_image + ", " +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageTag image_tag = (ImageTag) object;

        if (id_image != image_tag.getId_image()) return false;
        if (!name.equals(image_tag.getName())) return false;
        return true;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

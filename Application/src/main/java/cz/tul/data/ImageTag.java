package cz.tul.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Image_Tag")
@IdClass(ImageTagId.class)
public class ImageTag implements Serializable {

    @Id
    @Column(name="id_image")
    private int idImage;

    @Id
    @Column(name="name")
    private String name;

    public ImageTag() {
        ;
    }

    public ImageTag(int idImage, String name) {
        this.idImage = idImage;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Image_Tag{" +
                "idImage = " + idImage + ", " +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageTag image_tag = (ImageTag) object;

        if (idImage != image_tag.getIdImage()) return false;
        if (!name.equals(image_tag.getName())) return false;
        return true;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

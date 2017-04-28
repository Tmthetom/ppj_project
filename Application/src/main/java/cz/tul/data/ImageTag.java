package cz.tul.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Image_Tag")
public class ImageTag {

    @Id
    @Column(name="id_image")
    private int id_image;

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
    public String toString() {
        return "Image_Tag{" +
                "id_image = " + id_image + ", " +
                "name = " + name +
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
        ImageTag temp = (ImageTag)obj;
        if (getId_image() != temp.getId_image()) {
            return false;
        }
        if (!getName().equals(temp.getName())) {
            return false;
        }
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

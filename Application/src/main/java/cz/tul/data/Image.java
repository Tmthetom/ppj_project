package cz.tul.data;

import java.util.Date;

public class Image {

    private int id_image;
    private int id_author;
    private String name;
    private String path;
    private Date created;
    private Date updated;

    public Image() {
        ;
    }

    public Image(int id_image, int id_author, String name, String path, Date created, Date updated) {
        this.id_image = id_image;
        this.id_author = id_author;
        this.name = name;
        this.path = path;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id_image = " + id_image + ", " +
                "id_author = " + id_author + ", " +
                "name = " + name + ", " +
                "path = " + path + ", " +
                "created = " + created + ", " +
                "updated = " + updated +
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
        Image temp = (Image)obj;
        if (getId_image() != temp.getId_image()){
            return false;
        }
        if (!getPath().equals(temp.getPath())){
            return false;
        }
        if (getName() == null) {
            if (temp.getName() != null) {
                return false;
            }
        } else {
            if (temp.getName() == null) {
                return false;
            } else {
                if (!getName().equals(temp.getName())) {
                    return false;
                }
            }
        }
        if (getId_author() != temp.getId_author()) {
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

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}

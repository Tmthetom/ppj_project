package cz.tul.data;

import java.util.Date;

public class Image {

    private int id_image;
    private int id_author;
    private String name;
    private String path;
    private Date created;
    private Date updated;

    public Image(int id_image, int id_author, String name, String path, Date created, Date updated) {
        this.id_image = id_image;
        this.id_author = id_author;
        this.name = name;
        this.path = path;
        this.created = created;
        this.updated = updated;
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

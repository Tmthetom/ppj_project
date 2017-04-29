package cz.tul.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Image")
public class Image {

    @Id
    @GeneratedValue
    @Column(name="id_image")
    private int id_image;

    @ManyToOne
    @JoinColumn(name="id_author")
    private User author;

    @Column(name="name")
    private String name;

    @Column(name="path")
    private String path;

    @Column(name="created")
    private Date created;

    @Column(name="updated")
    private Date updated;

    public Image() {
        ;
    }

    public Image(User author, String path) {
        this.author = author;
        this.path = path;
    }

    public Image(User author, String name, String path) {
        this.author = author;
        this.name = name;
        this.path = path;
    }

    public Image(int id_image, User author, String name, String path, Date created, Date updated) {
        this.id_image = id_image;
        this.author = author;
        this.name = name;
        this.path = path;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id_image = " + id_image + ", " +
                "author = " + author + ", " +
                "name = " + name + ", " +
                "path = " + path + ", " +
                "created = " + created + ", " +
                "updated = " + updated +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Image image = (Image) object;

        if (id_image != image.getId_image()) return false;
        if (!path.equals(image.getPath()))return false;
        if (!author.equals(image.getAuthor())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @PrePersist
    public void prePersist(){
        Date date = new Date();
        setCreated(date);
        setUpdated(date);
    }

    @PreUpdate
    public void preUpdate(){
        setUpdated(new Date());
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

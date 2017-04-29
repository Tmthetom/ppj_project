package cz.tul.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="Comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="id_comment")
    private int id_comment;

    @ManyToOne
    @JoinColumn(name="id_image")
    private Image image;

    @ManyToOne
    @JoinColumn(name="id_author")
    private User author;

    @Column(name="message")
    private String message;

    @Column(name="created")
    private Date created;

    @Column(name="updated")
    private Date updated;

    public Comment() {
        ;
    }

    public Comment(Image image, User author, String message) {
        this.image = image;
        this.author = author;
        this.message = message;
    }

    public Comment(int id_comment, Image image, User author, String message, Date created, Date updated) {
        this.id_comment = id_comment;
        this.image = image;
        this.author = author;
        this.message = message;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id_comment = " + id_comment + ", " +
                "id_image = " + image + ", " +
                "author = " + author + ", " +
                "message = " + message + ", " +
                "created = " + created + ", " +
                "updated = " + updated +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Comment comment = (Comment) object;

        if (getId_comment() != comment.getId_comment()) return false;
        if (!getAuthor().equals(comment.getAuthor())) return false;
        if (!getImage().equals(comment.getImage())) return false;
        if (!getMessage().equals(comment.getMessage())) return false;
        return true;
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

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

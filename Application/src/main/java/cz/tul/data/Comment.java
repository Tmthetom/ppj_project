package cz.tul.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="id_comment")
    private int id_comment;

    @Column(name="id_image")
    private int id_image;

    @Column(name="id_author")
    private int id_author;

    @Column(name="message")
    private String message;

    @Column(name="created")
    private Date created;

    @Column(name="updated")
    private Date updated;

    public Comment() {
        ;
    }

    public Comment(int id_image, int id_author, String message) {
        this.id_image = id_image;
        this.id_author = id_author;
        this.message = message;
    }

    public Comment(int id_comment, int id_image, int id_author, String message, Date created, Date updated) {
        this.id_comment = id_comment;
        this.id_image = id_image;
        this.id_author = id_author;
        this.message = message;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id_comment = " + id_comment + ", " +
                "id_image = " + id_image + ", " +
                "id_author = " + id_author + ", " +
                "message = " + message + ", " +
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
        Comment temp = (Comment)obj;
        if (getId_comment() != temp.getId_comment()) {
            return false;
        }
        if (getId_author() != temp.getId_author()) {
            return false;
        }
        if (getId_image() != temp.getId_image()) {
            return false;
        }
        if (!getMessage().equals(temp.getMessage())) {
            return false;
        }
        return true;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
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

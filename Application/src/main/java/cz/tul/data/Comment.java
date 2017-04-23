package cz.tul.data;

import java.util.Date;

public class Comment {

    private int id_comment;
    private int id_image;
    private int id_author;
    private String message;
    private Date created;
    private Date updated;

    public Comment() {
        ;
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
        if (getId_author() != temp.getId_comment()) {
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

package cz.tul.data;

public class Comment_Rating {

    private int id_comment;
    private int id_user;
    private boolean rating;

    public Comment_Rating() {
        ;
    }

    public Comment_Rating(int id_comment, int id_user, boolean rating) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment_Rating{" +
                "id_comment = " + id_comment + ", " +
                "id_user = " + id_user + ", " +
                "rating = " + rating +
                '}';
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean getRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}

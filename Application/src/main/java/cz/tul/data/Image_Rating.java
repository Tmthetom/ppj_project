package cz.tul.data;

public class Image_Rating {

    private int id_image;
    private int id_user;
    private boolean rating;

    public Image_Rating(int id_image, int id_user, boolean rating) {
        this.id_image = id_image;
        this.id_user = id_user;
        this.rating = rating;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}

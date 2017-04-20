package cz.tul.data;

public class Image_Tag {

    private int id_image;
    private String name;

    public Image_Tag(int id_image, String name) {
        this.id_image = id_image;
        this.name = name;
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

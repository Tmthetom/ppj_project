package cz.tul.data;

public class Image_Tag {

    private int id_image;
    private String name;

    public Image_Tag() {
        ;
    }

    public Image_Tag(int id_image, String name) {
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
        Image_Tag temp = (Image_Tag)obj;
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

package cz.tul.data;

import java.io.Serializable;

public class ImageRatingId implements Serializable {
    int id_image;
    int id_user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageRatingId imageRatingId = (ImageRatingId) object;
        if (id_image != imageRatingId.id_image) return false;
        if (id_user != imageRatingId.id_user) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

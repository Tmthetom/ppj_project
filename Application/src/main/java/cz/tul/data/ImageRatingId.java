package cz.tul.data;

import java.io.Serializable;

public class ImageRatingId implements Serializable {
    int idImage;
    int id_user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageRatingId imageRatingId = (ImageRatingId) object;
        if (idImage != imageRatingId.idImage) return false;
        if (id_user != imageRatingId.id_user) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

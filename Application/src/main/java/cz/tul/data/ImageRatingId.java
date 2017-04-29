package cz.tul.data;

import java.io.Serializable;

public class ImageRatingId implements Serializable {
    Image image;
    User user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageRatingId imageRatingId = (ImageRatingId) object;
        if (image.getId_image() != imageRatingId.image.getId_image()) return false;
        return user.getId_user() != imageRatingId.user.getId_user();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

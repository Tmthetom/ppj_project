package cz.tul.data;

import java.io.Serializable;

public class ImageTagId implements Serializable {
    Image image;
    Tag tag;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageTagId imageTagId = (ImageTagId) object;
        if (image.getId_image() != imageTagId.image.getId_image()) return false;
        return tag.getName().equals(imageTagId.tag.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

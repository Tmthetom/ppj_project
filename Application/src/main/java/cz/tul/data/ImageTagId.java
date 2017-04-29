package cz.tul.data;

import java.io.Serializable;

public class ImageTagId implements Serializable {
    int id_image;
    String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageTagId imageTagId = (ImageTagId) object;

        if (id_image != imageTagId.id_image) return false;
        if (!name.equals(imageTagId.name)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

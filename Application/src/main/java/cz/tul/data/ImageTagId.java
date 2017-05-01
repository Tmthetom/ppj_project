package cz.tul.data;

import java.io.Serializable;

public class ImageTagId implements Serializable {
    int idImage;
    String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ImageTagId imageTagId = (ImageTagId) object;

        if (idImage != imageTagId.idImage) return false;
        if (!name.equals(imageTagId.name)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

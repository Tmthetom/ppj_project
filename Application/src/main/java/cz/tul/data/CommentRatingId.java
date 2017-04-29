package cz.tul.data;

import java.io.Serializable;

public class CommentRatingId implements Serializable {
    int id_comment;
    int id_user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CommentRatingId commentRatingId = (CommentRatingId) object;
        if (id_comment != commentRatingId.id_comment) return false;
        if (id_user != commentRatingId.id_user) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

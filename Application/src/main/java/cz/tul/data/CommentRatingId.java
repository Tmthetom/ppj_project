package cz.tul.data;

import java.io.Serializable;

public class CommentRatingId implements Serializable {
    Comment comment;
    User user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CommentRatingId commentRatingId = (CommentRatingId) object;
        if (comment.getId_comment() != commentRatingId.comment.getId_comment()) return false;
        return user.getId_user() != commentRatingId.user.getId_user();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

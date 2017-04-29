package cz.tul.repositories;

import cz.tul.data.CommentRatingId;
import cz.tul.data.Comment_Rating;
import cz.tul.data.Image_Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRatingRepository extends CrudRepository<Comment_Rating, CommentRatingId> {
    @Query("SELECT row FROM Comment_Rating AS row WHERE row.id_comment = :id_comment")
    public List<Image_Rating> getCommentRatings(@Param("id_comment") int id_comment);
}

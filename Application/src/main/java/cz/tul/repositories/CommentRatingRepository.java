package cz.tul.repositories;

import cz.tul.data.CommentRatingId;
import cz.tul.data.CommentRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRatingRepository extends CrudRepository<CommentRating, CommentRatingId> {
    @Query("SELECT row FROM CommentRating AS row WHERE row.id_comment = :id_comment")
    public List<CommentRating> getCommentRatings(@Param("id_comment") int id_comment);
}

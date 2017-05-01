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
    public List<CommentRating> findByIdComment(int idComment);
}

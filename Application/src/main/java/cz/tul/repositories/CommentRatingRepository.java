package cz.tul.repositories;

import cz.tul.data.CommentRatingId;
import cz.tul.data.CommentRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Comment_Rating", path = "Comment_Rating")
public interface CommentRatingRepository extends CrudRepository<CommentRating, CommentRatingId> {
    public List<CommentRating> findByIdComment(int idComment);
}

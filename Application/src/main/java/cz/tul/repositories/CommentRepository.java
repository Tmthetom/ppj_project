package cz.tul.repositories;

import cz.tul.data.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query("SELECT row FROM Comment AS row WHERE row.image = :image")
    public List<Comment> getImageComments(@Param("image") int image);
}

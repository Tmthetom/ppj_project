package cz.tul.repositories;

import cz.tul.data.ImageRatingId;
import cz.tul.data.ImageRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRatingRepository extends CrudRepository<ImageRating, ImageRatingId> {
    public List<ImageRating> findByIdImage(int idImage);
}

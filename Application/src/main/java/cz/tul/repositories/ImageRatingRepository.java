package cz.tul.repositories;

import cz.tul.data.ImageRatingId;
import cz.tul.data.ImageRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Image_Rating", path = "imageRatings")
public interface ImageRatingRepository extends CrudRepository<ImageRating, ImageRatingId> {
    public List<ImageRating> findByIdImage(int idImage);
}

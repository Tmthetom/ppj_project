package cz.tul.repositories;

import cz.tul.data.ImageRatingId;
import cz.tul.data.Image_Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRatingRepository extends CrudRepository<Image_Rating, ImageRatingId> {
    @Query("SELECT row FROM Image_Rating AS row WHERE row.id_image = :id_image")
    public List<Image_Rating> getImageRatings(@Param("id_image") int id_image);
}

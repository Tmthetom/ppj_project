package cz.tul.repositories;

import cz.tul.data.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageTagRepository extends CrudRepository<Image_Tag, ImageTagId> {
    @Query("SELECT row FROM Image_Tag AS row WHERE row.id_image = :id_image")
    public List<Image_Rating> getImageTags(@Param("id_image") int id_image);
}

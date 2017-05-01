package cz.tul.repositories;

import cz.tul.data.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageTagRepository extends CrudRepository<ImageTag, ImageTagId> {
    @Query("SELECT row FROM ImageTag AS row WHERE row.id_image = :id_image")
    public List<ImageTag> getImageTags(@Param("id_image") int id_image);
}

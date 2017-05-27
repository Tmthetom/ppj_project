package cz.tul.repositories;

import cz.tul.data.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "Image_Tag", path = "imageTags")
public interface ImageTagRepository extends CrudRepository<ImageTag, ImageTagId> {
    public List<ImageTag> findByIdImage(int idImage);
}

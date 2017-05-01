package cz.tul.repositories;

import cz.tul.data.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageTagRepository extends CrudRepository<ImageTag, ImageTagId> {
    public List<ImageTag> findByIdImage(int idImage);
}

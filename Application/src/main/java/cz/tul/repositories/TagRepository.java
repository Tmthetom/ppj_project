package cz.tul.repositories;

import cz.tul.data.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Tag", path = "Tag")
public interface TagRepository extends CrudRepository<Tag, String> {
}

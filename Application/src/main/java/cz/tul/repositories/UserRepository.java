package cz.tul.repositories;

import cz.tul.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "User")
public interface UserRepository extends CrudRepository<User, Integer> {
}

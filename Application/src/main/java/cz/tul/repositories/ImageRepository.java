package cz.tul.repositories;

import cz.tul.data.Image;
import cz.tul.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    @Query("SELECT row FROM Image AS row WHERE row.id_image = :id_image")
    public Image getImage(@Param("id_image") int id_image);

    @Query("SELECT row FROM Image AS row WHERE row.user = :user")
    public List<Image> findByAuthor(@Param("user") User user);

    @Query("SELECT row FROM Image AS row WHERE row.name = :name")
    public List<Image> findByName(@Param("name") String name);
}

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

    @Query("SELECT row FROM Image AS row WHERE row.author = :author")
    public List<Image> findByAuthor(@Param("author") User author);

    @Query("SELECT row FROM Image AS row WHERE row.name = :name")
    public List<Image> findByName(@Param("name") String name);

    @Query("SELECT row FROM Image AS row WHERE row.id_image IN (SELECT DISTINCT (tagRow.id_image) FROM Image_Tag AS tagRow WHERE tagRow.name = :tag)")
    public List<Image> findByTags(@Param("tag") String tag);
}

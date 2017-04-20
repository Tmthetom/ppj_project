package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ImageDao {
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Image image) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id_image", image.getId_image());
        params.addValue("id_author", image.getId_author());
        params.addValue("name", image.getName());
        params.addValue("path", image.getPath());
        params.addValue("created", image.getCreated());
        params.addValue("updated", image.getUpdated());

        return jdbc.update("INSERT INTO Image (id_image, id_author, name, path, created, updated) " +
                "VALUES (:id_image, :id_author, :name, :path, :created, :updated)", params) == 1;
    }

    public boolean exists(int id_image) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM Image WHERE id_image=:id_image",
                new MapSqlParameterSource("id_image", id_image), Integer.class) > 0;
    }

    public List<User> getAllImages() {
        return jdbc.query("SELECT * FROM Images", BeanPropertyRowMapper.newInstance(User.class));
    }

    public boolean update(Image image) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id_image", image.getId_image());
        params.addValue("id_author", image.getId_author());
        params.addValue("name", image.getName());
        params.addValue("path", image.getPath());
        params.addValue("created", image.getCreated());
        params.addValue("updated", image.getUpdated());

        return jdbc.update("UPDATE Image SET id_image=:id_image, id_author=:id_author, name=:name, path=:path, created=:created, updated=:updated where id_image=:id_image", params) == 1;
    }

    public void deleteImage() {
        jdbc.getJdbcOperations().execute("DELETE FROM Comment");
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Tag");
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Rating");
        jdbc.getJdbcOperations().execute("DELETE FROM Image");
    }
}

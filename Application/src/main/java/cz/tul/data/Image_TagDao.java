package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Image_TagDao {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Image_Tag tag) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id_image", tag.getId_image());
        params.addValue("name", tag.getName());

        return jdbc.update("INSERT INTO Image_Tag (id_image, name) " +
                "VALUES (:id_image, :name)", params) == 1;
    }

    public boolean exists(int id_image) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM Image_Tag WHERE id_image=:id_image",
                new MapSqlParameterSource("id_image", id_image), Integer.class) > 0;
    }

    public List<User> getAllImagesTags() {
        return jdbc.query("SELECT * FROM Image_Tag", BeanPropertyRowMapper.newInstance(User.class));
    }

    public boolean update(Image_Tag tag) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id_image", tag.getId_image());
        params.addValue("name", tag.getName());

        return jdbc.update("UPDATE Image_Tag SET id_image=:id_image, name=:name WHERE id_image=:id_image", params) == 1;
    }

    public void deleteTag() {
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Tag");
        jdbc.getJdbcOperations().execute("DELETE FROM Tag");
    }
}

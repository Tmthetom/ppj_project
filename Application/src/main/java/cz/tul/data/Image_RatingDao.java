package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Image_RatingDao {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Image_Rating rating) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_image", rating.getId_image());
        params.addValue("id_user", rating.getId_user());
        params.addValue("rating", rating.getRating());

        return jdbc.update("INSERT INTO Image_Rating (id_image, id_user, rating) " +
                "VALUES (:id_image, :id_user, :rating)", params) == 1;
    }

    public boolean exists(int id_image, int id_user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_image", id_image);
        params.addValue("id_user", id_user);

        return jdbc.queryForObject("SELECT COUNT(*) FROM Image_Rating WHERE id_image=:id_image AND id_user=:id_user",
                params, Integer.class) > 0;
    }

    public List<User> getAllImageRatings() {
        return jdbc.query("SELECT * FROM Image_Rating", BeanPropertyRowMapper.newInstance(User.class));
    }

    public boolean update(Image_Rating rating) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_image", rating.getId_image());
        params.addValue("id_user", rating.getId_user());
        params.addValue("rating", rating.getRating());

        return jdbc.update("UPDATE Image_Rating SET id_image=:id_image, id_user=:id_user, rating=:rating where id_image=:id_image", params) == 1;
    }

    public void deleteImageRatings() {
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Rating");
    }
}

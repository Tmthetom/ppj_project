package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class Comment_RatingsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Comment_Rating rating) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comment", rating.getId_comment());
        params.addValue("id_user", rating.getId_user());
        params.addValue("rating", rating.getRating());

        return jdbc.update("INSERT INTO Comment_Rating (id_comment, id_user, rating) " +
                "VALUES (:id_comment, :id_user, :rating)", params) == 1;
    }

    public boolean exists(int id_comment, int id_user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comment", id_comment);
        params.addValue("id_user", id_user);

        return jdbc.queryForObject("SELECT COUNT(*) FROM Comment_Rating WHERE id_comment=:id_comment AND id_user=:id_user",
                params, Integer.class) > 0;
    }

    public List<Comment_Rating> getAll() {
        return jdbc.query("SELECT * FROM Comment_Rating", BeanPropertyRowMapper.newInstance(Comment_Rating.class));
    }

    public void update(Comment_Rating rating) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comment", rating.getId_comment());
        params.addValue("id_user", rating.getId_user());
        params.addValue("rating", rating.getRating());

        return jdbc.update("UPDATE Comment_Rating SET id_comment=:id_comment, id_user=:id_user, rating=:rating WHERE id_comment=:id_comment", params) == 1;
    }

    public void deleteAll() {
        jdbc.getJdbcOperations().execute("DELETE FROM Comment_Rating");
    }
}

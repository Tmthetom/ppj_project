package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CommentRatingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(CommentRating comment_rating) {
        session().save(comment_rating);
    }

    public boolean exists(int id_comment, int id_user) {
        Criteria criteria = session().createCriteria(CommentRating.class);
        criteria.add(Restrictions.eq("id_comment", id_comment));
        criteria.add(Restrictions.eq("id_user", id_user));
        CommentRating comment_rating = (CommentRating) criteria.uniqueResult();
        return comment_rating != null;
    }

    public List<CommentRating> getAll() {
        Criteria criteria = session().createCriteria(CommentRating.class);
        return criteria.list();
    }

    public void update(CommentRating comment_rating) {
        session().update(comment_rating);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Comment_Rating").executeUpdate();
    }
}

package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class Comment_RatingsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Comment_Rating comment_rating) {
        session().save(comment_rating);
    }

    public boolean exists(int id_comment, int id_user) {
        Criteria criteria = session().createCriteria(Comment_Rating.class);
        criteria.add(Restrictions.eq("id_comment", id_comment));
        criteria.add(Restrictions.eq("id_user", id_user));
        Comment_Rating comment_rating = (Comment_Rating) criteria.uniqueResult();
        return comment_rating != null;
    }

    public List<Comment_Rating> getAll() {
        Criteria criteria = session().createCriteria(Comment_Rating.class);
        return criteria.list();
    }

    public void update(Comment_Rating comment_rating) {
        session().update(comment_rating);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Comment_Rating").executeUpdate();
    }
}

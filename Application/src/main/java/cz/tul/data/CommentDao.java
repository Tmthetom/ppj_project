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
public class CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Comment comment) {
        Date date = new Date();
        comment.setCreated(date);
        comment.setUpdated(date);
        session().save(comment);
    }

    public boolean exists(int id_comment) {
        Criteria criteria = session().createCriteria(Comment.class);
        criteria.add(Restrictions.idEq(id_comment));
        Comment comment = (Comment)criteria.uniqueResult();
        return comment != null;
    }

    public List<Comment> getAll() {
        Criteria criteria = session().createCriteria(Comment.class);
        return criteria.list();
    }

    public void update(Comment comment) {
        comment.setUpdated(new Date());
        session().update(comment);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Comment_Rating").executeUpdate();
        session().createQuery("DELETE FROM Comment").executeUpdate();
    }
}

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
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public int create(User user) {
        user.setRegistered(new Date());
        return (Integer) session().save(user);
    }

    public boolean exists(int id_user) {
        Criteria criteria = session().createCriteria(User.class);
        criteria.add(Restrictions.idEq(id_user));
        User user = (User)criteria.uniqueResult();
        return user != null;
    }

    public List<User> getAll() {
        Criteria criteria = session().createCriteria(User.class);
        return criteria.list();
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Comment_Rating").executeUpdate();
        session().createQuery("DELETE FROM Comment").executeUpdate();
        session().createQuery("DELETE FROM Image_Rating").executeUpdate();
        session().createQuery("DELETE FROM Image").executeUpdate();
        session().createQuery("DELETE FROM User").executeUpdate();
    }
}

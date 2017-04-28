package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TagsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Tag tag) {
        session().save(tag);
    }

    public boolean exists(Tag tag) {
        Criteria criteria = session().createCriteria(Tag.class);
        criteria.add(Restrictions.idEq(tag.getName()));
        tag = (Tag)criteria.uniqueResult();
        return tag != null;
    }

    public List<Tag> getAll() {
        Criteria criteria = session().createCriteria(Tag.class);
        return criteria.list();
    }

    public Tag get(Tag tag){
        Criteria criteria = session().createCriteria(Tag.class);
        criteria.add(Restrictions.idEq(tag.getName()));
        return (Tag) criteria.list().get(0);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Tag").executeUpdate();
        session().createQuery("DELETE FROM Tag").executeUpdate();
    }
}

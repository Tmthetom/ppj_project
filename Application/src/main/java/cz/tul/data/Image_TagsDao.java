package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class Image_TagsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Image_Tag image_tag) {
        session().save(image_tag);
    }

    public boolean exists(int id_image, String name) {
        Criteria criteria = session().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("id_image", id_image));
        criteria.add(Restrictions.eq("name", name));
        Image_Tag t = (Image_Tag) criteria.uniqueResult();
        return t != null;
    }

    public List<Image_Tag> getAll() {
        Criteria criteria = session().createCriteria(Image_Tag.class);
        return criteria.list();
    }

    public void update(Image_Tag image_tag) {
        session().update(image_tag);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Tag").executeUpdate();
    }
}

package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ImageTagDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(ImageTag image_tag) {
        session().save(image_tag);
    }

    public boolean exists(int id_image, String name) {
        Criteria criteria = session().createCriteria(ImageTag.class);
        criteria.add(Restrictions.eq("id_image", id_image));
        criteria.add(Restrictions.eq("name", name));
        ImageTag image_tag = (ImageTag) criteria.uniqueResult();
        return image_tag != null;
    }

    public List<ImageTag> getAll() {
        Criteria criteria = session().createCriteria(ImageTag.class);
        return criteria.list();
    }

    public void update(ImageTag image_tag) {
        session().update(image_tag);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Tag").executeUpdate();
    }
}

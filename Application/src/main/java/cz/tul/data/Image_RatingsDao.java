package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class Image_RatingsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(Image_Rating image_rating) {
        session().save(image_rating);
    }

    public boolean exists(int id_image, int id_user) {
        Criteria criteria = session().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("id_image", id_image));
        criteria.add(Restrictions.eq("id_user", id_user));
        Image_Rating image_rating = (Image_Rating) criteria.uniqueResult();
        return image_rating != null;
    }

    public List<Image_Rating> getAll() {
        Criteria criteria = session().createCriteria(Image_Rating.class);
        return criteria.list();
    }

    public void update(Image_Rating image_rating) {
        session().update(image_rating);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Rating").executeUpdate();
    }
}

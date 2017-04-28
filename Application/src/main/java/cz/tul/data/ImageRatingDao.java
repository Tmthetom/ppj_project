package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ImageRatingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void create(ImageRating image_rating) {
        session().save(image_rating);
    }

    public boolean exists(int id_image, int id_user) {
        Criteria criteria = session().createCriteria(ImageRating.class);
        criteria.add(Restrictions.eq("id_image", id_image));
        criteria.add(Restrictions.eq("id_user", id_user));
        ImageRating image_rating = (ImageRating) criteria.uniqueResult();
        return image_rating != null;
    }

    public List<ImageRating> getAll() {
        Criteria criteria = session().createCriteria(ImageRating.class);
        return criteria.list();
    }

    public void update(ImageRating image_rating) {
        session().update(image_rating);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Rating").executeUpdate();
    }
}

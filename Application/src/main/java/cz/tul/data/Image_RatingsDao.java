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

    public boolean exists(Image_Rating image_rating) {
        Criteria criteria = session().createCriteria(Image_Rating.class);
        criteria.add(Restrictions.eq("image", image_rating.getImage()));
        criteria.add(Restrictions.eq("user", image_rating.getUser()));
        image_rating = (Image_Rating) criteria.uniqueResult();
        return image_rating != null;
    }

    public List<Image_Rating> getAll() {
        Criteria criteria = session().createCriteria(Image_Rating.class);
        return criteria.list();
    }

    public Image_Rating get(Image_Rating image_rating){
        Criteria criteria = session().createCriteria(Image_Rating.class);
        criteria.add(Restrictions.eq("image", image_rating.getImage()));
        criteria.add(Restrictions.eq("user", image_rating.getUser()));
        return (Image_Rating) criteria.list().get(0);
    }

    public void update(Image_Rating image_rating) {
        session().update(image_rating);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Rating").executeUpdate();
    }
}

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
public class ImagesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public int create(Image image) {
        Date date = new Date();
        image.setCreated(date);
        image.setUpdated(date);
        return (Integer) session().save(image);
    }

    public boolean exists(int id_image) {
        Criteria criteria = session().createCriteria(Image.class);
        criteria.add(Restrictions.idEq(id_image));
        Image image = (Image)criteria.uniqueResult();
        return image != null;
    }

    public List<Image> getAll() {
        Criteria criteria = session().createCriteria(Image.class);
        return criteria.list();
    }

    public void update(Image image) {
        image.setUpdated(new Date());
        session().update(image);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Comment_Rating").executeUpdate();
        session().createQuery("DELETE FROM Comment").executeUpdate();
        session().createQuery("DELETE FROM Image_Tag").executeUpdate();
        session().createQuery("DELETE FROM Image_Rating").executeUpdate();
        session().createQuery("DELETE FROM Image").executeUpdate();
    }
}

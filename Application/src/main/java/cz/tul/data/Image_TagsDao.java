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

    public boolean exists(Image_Tag image_tag) {
        Criteria criteria = session().createCriteria(Image_Tag.class);
        criteria.add(Restrictions.eq("image", image_tag.getImage()));
        criteria.add(Restrictions.eq("tag", image_tag.getTag()));
        image_tag = (Image_Tag) criteria.uniqueResult();
        return image_tag != null;
    }

    public List<Image_Tag> getAll() {
        Criteria criteria = session().createCriteria(Image_Tag.class);
        return criteria.list();
    }

    public Image_Tag get(Image_Tag image_tag){
        Criteria criteria = session().createCriteria(Image_Tag.class);
        criteria.add(Restrictions.eq("image", image_tag.getImage()));
        criteria.add(Restrictions.eq("tag", image_tag.getTag()));
        return (Image_Tag) criteria.list().get(0);
    }

    public void update(Image_Tag image_tag) {
        session().update(image_tag);
    }

    public void deleteAll() {
        session().createQuery("DELETE FROM Image_Tag").executeUpdate();
    }
}

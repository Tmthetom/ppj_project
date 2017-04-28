package cz.tul;

import cz.tul.data.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("cz.tul.data")
public class Main {

    @Bean
    public CommentDao commentsDao() {
        return new CommentDao();
    }

    @Bean
    public CommentRatingDao comment_RatingsDao(){
        return new CommentRatingDao();
    }

    @Bean
    public ImageDao imagesDao(){
        return new ImageDao();
    }

    @Bean
    public ImageRatingDao image_RatingsDao(){
        return new ImageRatingDao();
    }

    @Bean
    public ImageTagDao image_TagsDao(){
        return new ImageTagDao();
    }

    @Bean
    public TagDao tagsDao(){
        return new TagDao();
    }

    @Bean
    public UserDao usersDao(){
        return new UserDao();
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(entityManagerFactory.unwrap(SessionFactory.class));
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);

        User user = new User("Tmthetom");
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.deleteAll();
        userDao.create(user);

        Image image = new Image(user.getId_user(), "New York","url");
        ImageDao imageDao = ctx.getBean(ImageDao.class);
        imageDao.deleteAll();
        imageDao.create(image);

        List<User> users = userDao.getAll();
        System.out.println(users);

        List<Image> images = imageDao.getAll();
        System.out.println(images);
    }
}
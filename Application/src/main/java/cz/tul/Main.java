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
    public CommentsDao commentsDao() {
        return new CommentsDao();
    }

    @Bean
    public Comment_RatingsDao comment_RatingsDao(){
        return new Comment_RatingsDao();
    }

    @Bean
    public ImagesDao imagesDao(){
        return new ImagesDao();
    }

    @Bean
    public Image_RatingsDao image_RatingsDao(){
        return new Image_RatingsDao();
    }

    @Bean
    public Image_TagsDao image_TagsDao(){
        return new Image_TagsDao();
    }

    @Bean
    public TagsDao tagsDao(){
        return new TagsDao();
    }

    @Bean
    public UsersDao usersDao(){
        return new UsersDao();
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

        UsersDao usersDao = ctx.getBean(UsersDao.class);
        usersDao.create(new User("Karel"));

        List<User> users = usersDao.getAllUsers();
        System.out.println(users);
    }
}
package cz.tul;

import cz.tul.data.*;
import cz.tul.services.ImageService;
import cz.tul.services.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("cz.tul.data")
@ComponentScan("cz.tul.services")
@EnableJpaRepositories(basePackages = "cz.tul.repositories")
public class Main {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Bean
    public SessionFactory sessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);

        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.getAll());

        /*
        User user = new User("Tmthetom");
        UsersDao usersDao = ctx.getBean(UsersDao.class);
        usersDao.deleteAll();
        usersDao.create(user);

        List<User> users = usersDao.getAll();
        System.out.println(users);

        User user1 = usersDao.get(user);
        System.out.println(user1);*/

    }
}
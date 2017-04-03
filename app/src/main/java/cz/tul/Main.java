package cz.tul;

import cz.tul.data.OffersDao;
import cz.tul.data.User2;
import cz.tul.data.Users2Dao;
import cz.tul.provisioning.Provisioner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
public class Main {

    @Bean
    public OffersDao offersDao() {
        return new OffersDao();
    }

    @Bean
    public Users2Dao usersDao() {
        return new Users2Dao();
    }

    @Profile({"devel", "test"})
    @Bean(initMethod = "doProvision")
    public Provisioner provisioner() {
        return new Provisioner();
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);

        Users2Dao usersDao = ctx.getBean(Users2Dao.class);

        List<User2> users = usersDao.getAllUsers();
        System.out.println(users);

    }

}
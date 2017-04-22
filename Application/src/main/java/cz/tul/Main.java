package cz.tul;

import cz.tul.data.*;
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

    @Profile({"devel", "test"})
    @Bean(initMethod = "doProvision")
    public Provisioner provisioner() {
        return new Provisioner();
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext ctx = app.run(args);

        UsersDao usersDao = ctx.getBean(UsersDao.class);

        List<User> users = usersDao.getAllUsers();
        System.out.println(users);
    }
}
package cz.tul;

import cz.tul.data.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Commnet_RatingsDaoTests {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private CommentsDao commentsDao;

    @Test
    public void testImage_Ratings(){
        usersDao.deleteUsers();
        imagesDao.deleteImages();
        commentsDao.deleteComments();

        User user = new User("Tmthetom");
        usersDao.create(user);

        Image image = new Image(user.getId_user(), "New York","url");
        imagesDao.create(image);

        Comment comment = new Comment(image.getId_image(), user.getId_user(), "WOW, such a nice image");
        assertTrue("Comment_rating should be created", commentsDao.create(comment));

        List<Comment> comments = commentsDao.getAllComments();
        assertEquals("Number of Comment_ratings should be 1", 1, comments.size());

        assertTrue("Comment_rating should exist", commentsDao.exists(comments.get(0).getId_comment()));

        assertEquals("Created Comment_rating should be identical to retrieved image_tag", comment, comments.get(0));
    }
}

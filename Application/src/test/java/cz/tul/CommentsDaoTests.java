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

public class CommentsDaoTests {

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Test
    public void testComments(){
        commentsDao.deleteAll();
        usersDao.deleteAll();
        imagesDao.deleteAll();

        User user = new User("Tmthetom");
        usersDao.create(user);
        user = usersDao.getAll().get(0);

        Image image = new Image(user, "obrazek","url");
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);

        Comment comment = new Comment(image, user, "comment");
        int id_comment = commentsDao.create(comment);

        List<Comment> comments = commentsDao.getAll();
        assertEquals("Number of comments should be 1", 1, comments.size());

        assertTrue("Comment id should exist", commentsDao.exists(id_comment));

        assertEquals("Created comment should be identical to retrieved comment", comment, comments.get(0));
    }
}

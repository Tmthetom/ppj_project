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

public class CommnetRatingDaoTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CommentRatingDao comment_ratingsDao;

    @Test
    public void testComment_Ratings(){
        userDao.deleteAll();
        imageDao.deleteAll();
        commentDao.deleteAll();
        comment_ratingsDao.deleteAll();

        User user = new User("Tmthetom");
        userDao.create(user);
        user = userDao.getAll().get(0);

        Image image = new Image(user.getId_user(), "New York","url");
        imageDao.create(image);
        image = imageDao.getAll().get(0);

        Comment comment = new Comment(image.getId_image(), user.getId_user(), "WOW, such a nice image");
        commentDao.create(comment);
        comment = commentDao.getAll().get(0);

        CommentRating comment_rating = new CommentRating(comment.getId_comment(), user.getId_user(), Boolean.TRUE);
        //assertTrue("Comment_rating should be created", comment_ratingsDao.create(comment_rating));
        comment_ratingsDao.create(comment_rating);
        comment_rating = comment_ratingsDao.getAll().get(0);

        List<CommentRating> comment_ratings = comment_ratingsDao.getAll();
        assertEquals("Number of Comment_ratings should be 1", 1, comment_ratings.size());

        assertTrue("Comment_rating should exist", comment_ratingsDao.exists(comment.getId_comment(), user.getId_user()));

        assertEquals("Created Comment_rating should be identical to retrieved image_tag", comment_rating, comment_ratings.get(0));
    }
}

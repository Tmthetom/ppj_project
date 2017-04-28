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
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private Comment_RatingsDao comment_ratingsDao;

    @Test
    public void testComment_Ratings(){
        usersDao.deleteAll();
        imagesDao.deleteAll();
        commentsDao.deleteAll();
        comment_ratingsDao.deleteAll();

        User user = new User("Tmthetom");
        usersDao.create(user);
        user = usersDao.getAll().get(0);

        Image image = new Image(user.getId_user(), "New York","url");
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);

        Comment comment = new Comment(image.getId_image(), user.getId_user(), "WOW, such a nice image");
        commentsDao.create(comment);
        comment = commentsDao.getAll().get(0);

        Comment_Rating comment_rating = new Comment_Rating(comment.getId_comment(), user.getId_user(), Boolean.TRUE);
        //assertTrue("Comment_rating should be created", comment_ratingsDao.create(comment_rating));
        comment_ratingsDao.create(comment_rating);
        comment_rating = comment_ratingsDao.getAll().get(0);

        List<Comment_Rating> comment_ratings = comment_ratingsDao.getAll();
        assertEquals("Number of Comment_ratings should be 1", 1, comment_ratings.size());

        assertTrue("Comment_rating should exist", comment_ratingsDao.exists(comment.getId_comment(), user.getId_user()));

        assertEquals("Created Comment_rating should be identical to retrieved image_tag", comment_rating, comment_ratings.get(0));
    }
}

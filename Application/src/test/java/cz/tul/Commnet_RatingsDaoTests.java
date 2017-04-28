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

    @Autowired
    private Comment_RatingsDao comment_ratingsDao;

    @Test
    public void testComment_Ratings(){
        usersDao.deleteAll();
        imagesDao.deleteAll();
        commentsDao.deleteAll();
        comment_ratingsDao.deleteAll();

        User user = new User("Tmthetom");
        user.setId_user(usersDao.create(user));
        user = usersDao.get(user);

        Image image = new Image(user, "New York","url");
        image.setId_image(imagesDao.create(image));
        image = imagesDao.get(image);

        Comment comment = new Comment(image, user, "WOW, such a nice image");
        commentsDao.create(comment);
        comment = commentsDao.get(comment);

        Comment_Rating comment_rating = new Comment_Rating(comment, user, Boolean.TRUE);
        comment_ratingsDao.create(comment_rating);

        List<Comment_Rating> comment_ratings = comment_ratingsDao.getAll();
        assertEquals("Number of Comment_ratings should be 1", 1, comment_ratings.size());

        assertTrue("Comment_rating should exist", comment_ratingsDao.exists(comment_rating));

        assertEquals("Created Comment_rating should be identical to retrieved Comment_rating",
                comment_rating, comment_ratingsDao.get(comment_rating));
    }
}

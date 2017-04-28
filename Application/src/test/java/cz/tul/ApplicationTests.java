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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ApplicationTests {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private TagsDao tagsDao;

    @Autowired
    private Image_TagsDao image_tagsDao;

    @Autowired
    private Image_RatingsDao image_ratingsDao;

    @Autowired
    private Comment_RatingsDao comment_ratingsDao;

    @Test
    public void testApplication(){

        // Clear hsql database
        usersDao.deleteAll();
        imagesDao.deleteAll();
        commentsDao.deleteAll();
        tagsDao.deleteAll();
        image_tagsDao.deleteAll();
        image_ratingsDao.deleteAll();
        comment_ratingsDao.deleteAll();

        // Create users
        User user1 = new User("Tmthetom");
        usersDao.create(user1);
        user1 = usersDao.getAll().get(0);

        User user2 = new User("Pavel");
        usersDao.create(user2);
        user2 = usersDao.getAll().get(1);

        // Create image with user 1
        Image image = new Image(user1, "New York","url");
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);

        // Update image
        image.setPath("url2");
        imagesDao.update(image);
        assertNotEquals("Image should have updated date", null, imagesDao.getAll().get(0).getUpdated());
        image = imagesDao.getAll().get(0);

        // Create tag
        Tag tag = new Tag("Mesto");
        tagsDao.create(tag);
        assertEquals("Tag should be equal", tag, tagsDao.getAll().get(0));
        tag = tagsDao.getAll().get(0);

        // Create image rating with user 2
        Image_Rating image_ratingBefore = new Image_Rating(image, user2, Boolean.FALSE);
        image_ratingsDao.create(image_ratingBefore);
        image_ratingBefore = image_ratingsDao.getAll().get(0);

        // Update image rating with user 2
        Image_Rating image_ratingAfter = image_ratingsDao.getAll().get(0);
        image_ratingAfter.setRating(!image_ratingAfter.getRating());
        image_ratingsDao.update(image_ratingAfter);
        image_ratingAfter = image_ratingsDao.getAll().get(0);

        // Check update of image rating
        assertNotEquals("Image rating should have updated rating", image_ratingBefore.getRating(),
                image_ratingAfter.getRating());

        // Create comment with user 2
        Comment comment = new Comment(image, user2, "I dunt like it dwq");
        commentsDao.create(comment);
        comment = commentsDao.getAll().get(0);

        // Update comment with user 2
        comment.setMessage("I dont like it");
        commentsDao.update(comment);
        comment = commentsDao.getAll().get(0);
        assertNotEquals("Comment should have updated date", null, commentsDao.getAll().get(0).getUpdated());

        // Create comment rating with user 1
        Comment_Rating comment_rating = new Comment_Rating(comment, user1, Boolean.FALSE);
        comment_ratingsDao.create(comment_rating);
        comment_rating = comment_ratingsDao.getAll().get(0);
        assertEquals("Comment_rating should be equal", comment_rating, comment_ratingsDao.getAll().get(0));
    }
}

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
    private UserDao userDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ImageTagDao image_tagsDao;

    @Autowired
    private ImageRatingDao image_ratingsDao;

    @Autowired
    private CommentRatingDao comment_ratingsDao;

    @Test
    public void testApplication(){

        // Clear hsql database
        userDao.deleteAll();
        imageDao.deleteAll();
        commentDao.deleteAll();
        tagDao.deleteAll();
        image_tagsDao.deleteAll();
        image_ratingsDao.deleteAll();
        comment_ratingsDao.deleteAll();

        // Create users
        User user1 = new User("Tmthetom");
        //assertTrue("User 1 should be created", usersDao.create(user1));
        userDao.create(user1);
        user1 = userDao.getAll().get(0);
        assertEquals("User 1 should be equal", user1, userDao.getAll().get(0));

        User user2 = new User("Pavel");
        //assertTrue("User 2 should be created", usersDao.create(user2));
        userDao.create(user2);
        user2 = userDao.getAll().get(1);
        assertEquals("User 2 should be equal", user2, userDao.getAll().get(1));

        // Create image with user 1
        Image image = new Image(user1.getId_user(), "New York","url");
        //assertTrue("Image should be created", imagesDao.create(image));
        imageDao.create(image);
        image = imageDao.getAll().get(0);
        assertEquals("Image should be equal", image, imageDao.getAll().get(0));

        // Update image
        image.setPath("url2");
        //assertTrue("Image update should be created", imagesDao.update(image));
        imageDao.update(image);
        assertNotEquals("Image should have updated date", null, imageDao.getAll().get(0).getUpdated());
        image = imageDao.getAll().get(0);

        // Create tag
        Tag tag = new Tag("Mesto");
        //assertTrue("Tag should be created", tagsDao.create(tag));
        tagDao.create(tag);
        assertEquals("Tag should be equal", tag, tagDao.getAll().get(0));
        tag = tagDao.getAll().get(0);

        // Create image rating with user 2
        ImageRating image_rating = new ImageRating(image.getId_image(), user2.getId_user(), Boolean.FALSE);
        //assertTrue("Image_Rating should be created", image_ratingsDao.create(image_rating));
        image_ratingsDao.create(image_rating);
        image_rating = image_ratingsDao.getAll().get(0);
        assertEquals("Image_Rating should be equal", image_rating, image_ratingsDao.getAll().get(0));

        // Create comment with user 2
        Comment comment = new Comment(image.getId_image(), user2.getId_user(), "I dunt like it dwq");
        //assertTrue("Comment should be created", commentsDao.create(comment));
        commentDao.create(comment);
        comment = commentDao.getAll().get(0);
        assertEquals("Comment should be equal", comment, commentDao.getAll().get(0));

        // Update comment with user 2
        comment.setMessage("I dont like it");
        //assertTrue("Comment should be created", commentsDao.update(comment));
        commentDao.update(comment);
        comment = commentDao.getAll().get(0);
        assertNotEquals("Comment should have updated date", null, commentDao.getAll().get(0).getUpdated());

        // Create comment rating with user 1
        CommentRating comment_rating = new CommentRating(comment.getId_comment(), user1.getId_user(), Boolean.FALSE);
        //assertTrue("Comment_rating should be created", comment_ratingsDao.create(comment_rating));
        comment_ratingsDao.create(comment_rating);
        comment_rating = comment_ratingsDao.getAll().get(0);
        assertEquals("Comment_rating should be equal", comment_rating, comment_ratingsDao.getAll().get(0));
    }
}

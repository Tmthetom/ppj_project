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
        //assertTrue("User 1 should be created", usersDao.create(user1));
        usersDao.create(user1);
        user1 = usersDao.getAll().get(0);
        assertEquals("User 1 should be equal", user1, usersDao.getAll().get(0));

        User user2 = new User("Pavel");
        //assertTrue("User 2 should be created", usersDao.create(user2));
        usersDao.create(user2);
        user2 = usersDao.getAll().get(1);
        assertEquals("User 2 should be equal", user2, usersDao.getAll().get(1));

        // Create image with user 1
        Image image = new Image(user1.getId_user(), "New York","url");
        //assertTrue("Image should be created", imagesDao.create(image));
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);
        assertEquals("Image should be equal", image, imagesDao.getAll().get(0));

        // Update image
        image.setPath("url2");
        //assertTrue("Image update should be created", imagesDao.update(image));
        imagesDao.update(image);
        assertNotEquals("Image should have updated date", null, imagesDao.getAll().get(0).getUpdated());
        image = imagesDao.getAll().get(0);

        // Create tag
        Tag tag = new Tag("Mesto");
        //assertTrue("Tag should be created", tagsDao.create(tag));
        tagsDao.create(tag);
        assertEquals("Tag should be equal", tag, tagsDao.getAll().get(0));
        tag = tagsDao.getAll().get(0);

        // Create image rating with user 2
        Image_Rating image_rating = new Image_Rating(image.getId_image(), user2.getId_user(), Boolean.FALSE);
        //assertTrue("Image_Rating should be created", image_ratingsDao.create(image_rating));
        image_ratingsDao.create(image_rating);
        image_rating = image_ratingsDao.getAll().get(0);
        assertEquals("Image_Rating should be equal", image_rating, image_ratingsDao.getAll().get(0));

        // Create comment with user 2
        Comment comment = new Comment(image.getId_image(), user2.getId_user(), "I dunt like it dwq");
        //assertTrue("Comment should be created", commentsDao.create(comment));
        commentsDao.create(comment);
        comment = commentsDao.getAll().get(0);
        assertEquals("Comment should be equal", comment, commentsDao.getAll().get(0));

        // Update comment with user 2
        comment.setMessage("I dont like it");
        //assertTrue("Comment should be created", commentsDao.update(comment));
        commentsDao.update(comment);
        comment = commentsDao.getAll().get(0);
        assertNotEquals("Comment should have updated date", null, commentsDao.getAll().get(0).getUpdated());

        // Create comment rating with user 1
        Comment_Rating comment_rating = new Comment_Rating(comment.getId_comment(), user1.getId_user(), Boolean.FALSE);
        //assertTrue("Comment_rating should be created", comment_ratingsDao.create(comment_rating));
        comment_ratingsDao.create(comment_rating);
        comment_rating = comment_ratingsDao.getAll().get(0);
        assertEquals("Comment_rating should be equal", comment_rating, comment_ratingsDao.getAll().get(0));
    }
}

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

public class Image_RatingsDaoTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ImageRatingDao image_ratingsDao;

    @Test
    public void testImage_Ratings(){
        userDao.deleteAll();
        imageDao.deleteAll();
        image_ratingsDao.deleteAll();

        User user = new User("Tmthetom");
        userDao.create(user);
        user = userDao.getAll().get(0);

        Image image = new Image(user.getId_user(), "New York","url");
        imageDao.create(image);
        image = imageDao.getAll().get(0);

        ImageRating rating = new ImageRating(image.getId_image(), user.getId_user(), Boolean.TRUE);
        //assertTrue("Image_rating should be created", image_ratingsDao.create(rating));
        image_ratingsDao.create(rating);

        List<ImageRating> ratings = image_ratingsDao.getAll();
        assertEquals("Number of Image_ratings should be 1", 1, ratings.size());

        assertTrue("Image_rating should exist", image_ratingsDao.exists(ratings.get(0).getId_image(), ratings.get(0).getId_user()));

        assertEquals("Created Image_rating should be identical to retrieved image_tag", rating, ratings.get(0));
    }
}

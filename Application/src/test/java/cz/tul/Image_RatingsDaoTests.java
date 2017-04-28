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
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private Image_RatingsDao image_ratingsDao;

    @Test
    public void testImage_Ratings(){
        usersDao.deleteAll();
        imagesDao.deleteAll();
        image_ratingsDao.deleteAll();

        User user = new User("Tmthetom");
        usersDao.create(user);
        user = usersDao.getAll().get(0);

        Image image = new Image(user, "New York","url");
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);

        Image_Rating image_rating = new Image_Rating(image, user, Boolean.TRUE);
        image_ratingsDao.create(image_rating);

        List<Image_Rating> image_ratings = image_ratingsDao.getAll();
        assertEquals("Number of Image_ratings should be 1", 1, image_ratings.size());

        assertTrue("Image_rating should exist", image_ratingsDao.exists(image_rating.getImage(), image_rating.getUser()));

        assertEquals("Created Image_rating should be identical to retrieved Image_rating", image_rating, image_ratings.get(0));
    }
}

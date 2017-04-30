package cz.tul;

import cz.tul.data.*;
import cz.tul.services.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageRatingServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRatingService imageRatingService;

    @Before
    public void init() {
        imageService.deleteAll();
        userService.deleteAll();
        imageRatingService.deleteAll();
    }

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");

    private Image image1 = new Image(user1, "Sunrise","Path");

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);

        Image_Rating image_rating1 = new Image_Rating(image1.getId_image(), user1.getId_user(), Boolean.TRUE);
        imageRatingService.create(image_rating1);
        List<Image_Rating> image_ratings1 = imageRatingService.getAll();
        assertEquals("One imagesRating should have been created and retrieved.", 1, image_ratings1.size());
        assertEquals("Inserted imagesRating should match retrieved.", image_rating1, image_ratings1.get(0));

        Image_Rating image_rating2 = new Image_Rating(image1.getId_image(), user2.getId_user(), Boolean.FALSE);
        imageRatingService.create(image_rating2);
        List<Image_Rating> image_ratings2 = imageRatingService.getAll();
        assertEquals("Should be two retrieved imagesRatings.", 2, image_ratings2.size());
    }

    @Test
    public void testUpdate() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);

        Image_Rating image_rating = new Image_Rating(image1.getId_image(), user1.getId_user(), Boolean.TRUE);
        imageRatingService.create(image_rating);

        image_rating.setRating(Boolean.FALSE);
        imageRatingService.update(image_rating);

        Image_Rating retrieved = imageRatingService.getImageRatings(image1).get(0);
        assertEquals("Retrieved imagesRating should be updated.", image_rating, retrieved);
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);

        Image_Rating image_rating = new Image_Rating(image1.getId_image(), user1.getId_user(), Boolean.TRUE);
        imageRatingService.create(image_rating);

        List<Image_Rating> image_ratings1 = imageRatingService.getAll();
        assertEquals("All imagesRating should have been created and retrieved.", 1, image_ratings1.size());

        imageRatingService.delete(image_rating);

        List<Image_Rating> image_ratings2 = imageRatingService.getAll();
        assertEquals("All imagesRating should have been deleted.", 0, image_ratings2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);

        Image_Rating image_rating = new Image_Rating(image1.getId_image(), user1.getId_user(), Boolean.TRUE);
        imageRatingService.create(image_rating);

        List<Image_Rating> image_ratings1 = imageRatingService.getAll();
        assertEquals("All imagesRating should have been created and retrieved.", 1, image_ratings1.size());

        imageRatingService.deleteAll();

        List<Image_Rating> image_ratings2 = imageRatingService.getAll();
        assertEquals("All imagesRating should have been deleted.", 0, image_ratings2.size());
    }
}

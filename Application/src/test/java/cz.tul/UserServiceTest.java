package cz.tul;

import cz.tul.data.Image;
import cz.tul.data.User;
import cz.tul.services.ImageService;
import cz.tul.services.UserService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");

    @Autowired
    private ImageService imageService;

    Image image1 = new Image(user1, "Path");
    Image image2 = new Image(user1, "Path");
    Image image3 = new Image(user2, "Path");

    @Before
    public void init() {
        userService.deleteAll();
        imageService.deleteAll();
    }

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        List<Image> images1 = imageService.getAll();
        assertEquals("One image should have been created and retrieved.", 1, images1.size());
        assertEquals("Inserted image should match retrieved.", image1, images1.get(0));

        imageService.create(image2);
        imageService.create(image3);
        List<Image> images2 = imageService.getAll();
        assertEquals("Should be four retrieved images.", 3, images2.size());
    }

    @Test
    public void testExists() {
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        assertTrue("User should exist.", userService.exists(user2));

        User user4 = new User("Dominik Hasek");
        assertFalse("User should not exist.", userService.exists(user4));
    }
}

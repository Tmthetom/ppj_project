package cz.tul;

import cz.tul.data.Image;
import cz.tul.data.Image_Tag;
import cz.tul.data.Tag;
import cz.tul.data.User;
import cz.tul.services.ImageService;
import cz.tul.services.ImageTagService;
import cz.tul.services.TagService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ImageTagService imageTagService;

    @Before
    public void init() {
        imageService.deleteAll();
        userService.deleteAll();
        tagService.deleteAll();
        imageTagService.deleteAll();
    }

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");

    private Image image1 = new Image(user1, "Sunrise","Path");
    private Image image2 = new Image(user1, "Wolf","Path");
    private Image image3 = new Image(user2, "House","Path");

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
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);
        assertTrue("Image should exist.", imageService.exists(image2));

        Image image4 = new Image(user2, "Path");
        assertFalse("Image should not exist.", imageService.exists(image4));
    }

    @Test
    public void testGet() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        Image retrieved = imageService.getImage(image2);
        assertEquals("Image should match retrieved.", image2, retrieved);
    }

    @Test
    public void testGetByName() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        List<Image> images1 = imageService.getByName(image2.getName());
        assertNotNull("Retrieved images should not be null.", images1);
        assertEquals("Retrieved image should be 1 for this name.", 1, images1.size());
    }

    @Test
    public void testGetByAuthor() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        List<Image> images1 = imageService.getByAuthor(user1);
        assertNotNull("Retrieved images should not be null.", images1);
        assertEquals("Retrieved images should be 2 for this author.", 2, images1.size());
    }

    @Test
    public void testGetByTags() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        Tag tag1 = new Tag("City");
        Tag tag2 = new Tag("Nature");
        Tag tag3 = new Tag("Animals");
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        Image_Tag image_tag1 = new Image_Tag(image3.getId_image(), tag1.getName());
        Image_Tag image_tag2 = new Image_Tag(image1.getId_image(), tag2.getName());
        Image_Tag image_tag3 = new Image_Tag(image2.getId_image(), tag1.getName());
        imageTagService.create(image_tag1);
        imageTagService.create(image_tag2);
        imageTagService.create(image_tag3);

        List<Image> images1 = imageService.getByTag(tag1);
        assertNotNull("Retrieved images should not be null.", images1);
        assertEquals("Retrieved images should be 2 for this tags.", 2, images1.size());
    }

    @Test
    public void testUpdate() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        image2.setPath("New Path");
        imageService.update(image2);

        Image retrieved = imageService.getImage(image2);
        assertEquals("Retrieved image should be updated.", image2, retrieved);
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);

        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        List<Image> images1 = imageService.getAll();
        assertEquals("All images should have been created and retrieved.", 3, images1.size());

        imageService.delete(image1);
        imageService.delete(image2);
        imageService.delete(image3);

        List<Image> images2 = imageService.getAll();
        assertEquals("All images should have been deleted.", 0, images2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);

        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);

        List<Image> images1 = imageService.getAll();
        assertEquals("All images should have been created and retrieved.", 3, images1.size());

        imageService.deleteAll();

        List<Image> images2 = imageService.getAll();
        assertEquals("All images should have been deleted.", 0, images2.size());
    }
}

package cz.tul;

import cz.tul.data.Image;
import cz.tul.data.ImageTag;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageTagServiceTest {

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

    private Tag tag1 = new Tag("City");
    private Tag tag2 = new Tag("Nature");
    private Tag tag3 = new Tag("Animals");

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        ImageTag image_tag1 = new ImageTag(image3.getId_image(), tag1.getName());
        ImageTag image_tag2 = new ImageTag(image1.getId_image(), tag2.getName());
        ImageTag image_tag3 = new ImageTag(image2.getId_image(), tag3.getName());

        imageTagService.create(image_tag1);

        List<ImageTag> image_tags1 = imageTagService.getAll();
        assertEquals("One imageTag should have been created and retrieved.", 1, image_tags1.size());
        assertEquals("Inserted imageTags should match retrieved.", image_tag1, image_tags1.get(0));

        imageTagService.create(image_tag2);
        imageTagService.create(image_tag3);
        List<ImageTag> image_tags2 = imageTagService.getAll();
        assertEquals("Should be three retrieved imageTags.", 3, image_tags2.size());
    }

    @Test
    public void testGetImageTags() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        ImageTag image_tag1 = new ImageTag(image3.getId_image(), tag1.getName());
        ImageTag image_tag2 = new ImageTag(image1.getId_image(), tag2.getName());
        ImageTag image_tag3 = new ImageTag(image2.getId_image(), tag3.getName());

        imageTagService.create(image_tag1);
        imageTagService.create(image_tag2);
        imageTagService.create(image_tag3);

        List<ImageTag> image_tags = imageTagService.getImageTags(image1);
        assertNotNull("Retrieved imageTags should not be null.", image_tags);
        assertEquals("Retrieved imageTags should be 1 for this name.", 1, image_tags.size());
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        ImageTag image_tag1 = new ImageTag(image3.getId_image(), tag1.getName());
        ImageTag image_tag2 = new ImageTag(image1.getId_image(), tag2.getName());
        ImageTag image_tag3 = new ImageTag(image2.getId_image(), tag3.getName());

        imageTagService.create(image_tag1);
        imageTagService.create(image_tag2);
        imageTagService.create(image_tag3);

        List<ImageTag> image_tags1 = imageTagService.getAll();
        assertEquals("All imageTags should have been created and retrieved.", 3, image_tags1.size());

        imageTagService.delete(image_tag1);
        imageTagService.delete(image_tag2);
        imageTagService.delete(image_tag3);

        List<ImageTag> image_tags2 = imageTagService.getAll();
        assertEquals("All imageTags should have been deleted.", 0, image_tags2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        imageService.create(image3);
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        ImageTag image_tag1 = new ImageTag(image3.getId_image(), tag1.getName());
        ImageTag image_tag2 = new ImageTag(image1.getId_image(), tag2.getName());
        ImageTag image_tag3 = new ImageTag(image2.getId_image(), tag3.getName());

        imageTagService.create(image_tag1);
        imageTagService.create(image_tag2);
        imageTagService.create(image_tag3);

        List<ImageTag> image_tags1 = imageTagService.getAll();
        assertEquals("All imageTags should have been created and retrieved.", 3, image_tags1.size());

        imageTagService.deleteAll();

        List<ImageTag> image_tags2 = imageTagService.getAll();
        assertEquals("All imageTags should have been deleted.", 0, image_tags2.size());
    }
}

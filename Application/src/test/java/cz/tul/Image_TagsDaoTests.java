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

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Image_TagsDaoTests {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private TagsDao tagsDao;

    @Autowired
    private ImagesDao imagesDao;

    @Autowired
    private Image_TagsDao image_tagsDao;

    @Test
    public void testImage_Tags(){
        usersDao.deleteUsers();
        tagsDao.deleteTags();
        imagesDao.deleteImages();

        User user = new User("Tmthetom");
        usersDao.create(user);

        Tag tag = new Tag("Mesto");
        tagsDao.create(tag);

        Image image = new Image(user.getId_user(), "New York","url");
        imagesDao.create(image);

        Image_Tag image_tag = new Image_Tag(image.getId_image(), tag.getName());
        assertTrue("Image_tag should be created", image_tagsDao.create(image_tag));

        List<Image_Tag> image_tags = image_tagsDao.getAllImagesTags();
        assertEquals("Number of image_tags should be 1", 1, image_tags.size());

        assertTrue("Image_tag should exist", image_tagsDao.exists(image_tags.get(0).getId_image(), image_tags.get(0).getName()));

        assertEquals("Created image_tag should be identical to retrieved image_tag", image_tag, image_tags.get(0));
    }
}

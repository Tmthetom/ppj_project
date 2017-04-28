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

public class ImageTagDaoTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private ImageTagDao image_tagsDao;

    @Test
    public void testImage_Tags(){
        userDao.deleteAll();
        tagDao.deleteAll();
        imageDao.deleteAll();
        image_tagsDao.deleteAll();

        User user = new User("Tmthetom");
        userDao.create(user);
        user = userDao.getAll().get(0);

        Tag tag = new Tag("Mesto");
        tagDao.create(tag);
        tag = tagDao.getAll().get(0);

        Image image = new Image(user.getId_user(), "New York","url");
        imageDao.create(image);
        image = imageDao.getAll().get(0);

        ImageTag image_tag = new ImageTag(image.getId_image(), tag.getName());
        //assertTrue("Image_tag should be created", image_tagsDao.create(image_tag));
        image_tagsDao.create(image_tag);
        image_tag = image_tagsDao.getAll().get(0);

        List<ImageTag> image_tags = image_tagsDao.getAll();
        assertEquals("Number of image_tags should be 1", 1, image_tags.size());

        assertTrue("Image_tag should exist", image_tagsDao.exists(image_tags.get(0).getId_image(), image_tags.get(0).getName()));

        assertEquals("Created image_tag should be identical to retrieved image_tag", image_tag, image_tags.get(0));
    }
}

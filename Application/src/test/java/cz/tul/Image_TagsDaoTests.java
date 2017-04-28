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
        usersDao.deleteAll();
        tagsDao.deleteAll();
        imagesDao.deleteAll();
        image_tagsDao.deleteAll();

        User user = new User("Tmthetom");
        user.setId_user(usersDao.create(user));
        user = usersDao.get(user);

        Tag tag = new Tag("Mesto");
        tagsDao.create(tag);
        tag = tagsDao.getAll().get(0);

        Image image = new Image(user, "New York","url");
        image.setId_image(imagesDao.create(image));
        image = imagesDao.get(image);

        Image_Tag image_tag = new Image_Tag(image, tag);
        image_tagsDao.create(image_tag);

        List<Image_Tag> image_tags = image_tagsDao.getAll();
        assertEquals("Number of image_tags should be 1", 1, image_tags.size());

        assertTrue("Image_tag should exist", image_tagsDao.exists(image_tag));

        assertEquals("Created image_tag should be identical to retrieved image_tag",
                image_tag, image_tagsDao.get(image_tag));
    }
}

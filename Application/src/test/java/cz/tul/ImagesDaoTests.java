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

public class ImagesDaoTests {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ImagesDao imagesDao;

    @Test
    public void testImages(){
        imagesDao.deleteAll();
        usersDao.deleteAll();

        User user = new User("Tmthetom");
        usersDao.create(user);
        user = usersDao.getAll().get(0);

        Image image = new Image(user, "New York","url");
        //assertTrue("Image should be created", imagesDao.create(image));
        imagesDao.create(image);
        image = imagesDao.getAll().get(0);

        List<Image> images = imagesDao.getAll();
        assertEquals("Number of images should be 1", 1, images.size());

        assertTrue("Image should exist", imagesDao.exists(images.get(0).getId_image()));

        assertEquals("Created comment image be identical to retrieved comment", image, images.get(0));
    }
}

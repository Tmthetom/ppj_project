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
        imagesDao.deleteImages();
        usersDao.deleteUsers();

        User a = new User("Tmthetom");
        usersDao.create(a);

        Image i = new Image(a.getId_user(), "obrazek","url");
        assertTrue("Image should be created", imagesDao.create(i));

        List<Image> images = imagesDao.getAllImages();
        assertEquals("Number of comments should be 1", 1, images.size());

        assertTrue("Comment should exist", imagesDao.exists(images.get(0).getId_image()));

        assertEquals("Created comment should be identical to retrieved comment", i, images.get(0));
    }
}

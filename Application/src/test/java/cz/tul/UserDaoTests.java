package cz.tul;

import cz.tul.data.User;
import cz.tul.data.UserDao;
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

public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUsers() {
        userDao.deleteAll();

        User user = new User("Tmthetom");
        //assertTrue("User creation should return true", usersDao.create(user));
        userDao.create(user);
        user = userDao.getAll().get(0);

        List<User> users = userDao.getAll();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User should exist.", userDao.exists(user.getId_user()));

        assertEquals("Created user should be identical to retrieved user",
                user, users.get(0));
    }
}

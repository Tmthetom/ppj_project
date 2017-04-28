package cz.tul;

import cz.tul.data.User;
import cz.tul.data.UsersDao;
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

public class UsersDaoTests {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void testUsers() {
        usersDao.deleteAll();

        User user = new User("Tmthetom");
        user.setId_user(usersDao.create(user));

        List<User> users = usersDao.getAll();
        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User id should exist.", usersDao.exists(user));

        assertEquals("Created user should be identical to retrieved user",
                user, usersDao.get(user));
    }
}

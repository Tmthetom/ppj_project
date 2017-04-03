package cz.tul;

import cz.tul.data.User2;
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

        usersDao.deleteUsers();

        User2 user = new User2("developer", "Petr", "hellothere",
                "petr@seznam.cz", true, "user");

        assertTrue("User2 creation should return true", usersDao.create(user));

        List<User2> users = usersDao.getAllUsers();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User2 should exist.", usersDao.exists(user.getUsername()));

        assertEquals("Created user should be identical to retrieved user",
                user, users.get(0));

    }
}

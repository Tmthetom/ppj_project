package cz.tul;

import cz.tul.data.User;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void init() {
        userService.deleteAll();
    }

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");
    private User user3 = new User("Karel Kraus");

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        List<User> users1 = userService.getAll();
        assertEquals("One user should have been created and retrieved.", 1, users1.size());
        assertEquals("Inserted user should match retrieved.", user1, users1.get(0));

        userService.create(user2);
        userService.create(user3);
        List<User> users2 = userService.getAll();
        assertEquals("Should be three retrieved users.", 3, users2.size());
    }

    @Test
    public void testExists() {
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        assertTrue("User should exist.", userService.exists(user2));

        User user4 = new User("Dominik Hasek");
        assertFalse("User should not exist.", userService.exists(user4));
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);

        List<User> users1 = userService.getAll();
        assertEquals("All users should have been created and retrieved.", 3, users1.size());

        userService.delete(user1);
        userService.delete(user2);
        userService.delete(user3);

        List<User> users2 = userService.getAll();
        assertEquals("All users should have been deleted.", 0, users2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);
        userService.create(user3);

        List<User> users1 = userService.getAll();
        assertEquals("All users should have been created and retrieved.", 3, users1.size());

        userService.deleteAll();

        List<User> users2 = userService.getAll();
        assertEquals("All users should have been deleted.", 0, users2.size());
    }
}

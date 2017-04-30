package cz.tul;

import cz.tul.data.Tag;
import cz.tul.services.TagService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Main.class})
@ActiveProfiles({"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Before
    public void init() {
        tagService.deleteAll();
    }

    Tag tag1 = new Tag("City");
    Tag tag2 = new Tag("Nature");
    Tag tag3 = new Tag("Animals");

    @Test
    public void testCreateRetrieve(){
        tagService.create(tag1);
        List<Tag> tags1 = tagService.getAll();
        assertEquals("One tag should have been created and retrieved.", 1, tags1.size());
        assertEquals("Inserted tag should match retrieved.", tag1, tags1.get(0));

        tagService.create(tag2);
        tagService.create(tag3);
        List<Tag> tags2 = tagService.getAll();
        assertEquals("Should be four retrieved tags.", 3, tags2.size());
    }

    @Test
    public void testExists() {
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);
        assertTrue("Tag should exist.", tagService.exists(tag2));

        Tag tag4 = new Tag("Games");
        assertFalse("Tag should not exist.", tagService.exists(tag4));
    }

    @Test
    public void testDelete() {
        tagService.create(tag1);
        tagService.create(tag2);
        tagService.create(tag3);

        List<Tag> tags1 = tagService.getAll();
        assertEquals("All tags should have been created and retrieved.", 3, tags1.size());

        tagService.delete(tag1);
        tagService.delete(tag2);
        tagService.delete(tag3);

        List<Tag> tags2 = tagService.getAll();
        assertEquals("All tags should have been deleted.", 0, tags2.size());
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

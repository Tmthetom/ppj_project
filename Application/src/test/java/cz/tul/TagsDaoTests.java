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

public class TagsDaoTests {

    @Autowired
    private TagsDao tagsDao;

    @Test
    public void testTags() {
        tagsDao.deleteAll();

        Tag tag = new Tag("Mesto");
        assertTrue("Tag creation should return true", tagsDao.create(tag));
        tag = tagsDao.getAll().get(0);

        List<Tag> tags = tagsDao.getAll();

        assertEquals("Number of tags should be 1.", 1, tags.size());

        assertTrue("Tag should exist.", tagsDao.exists(tag.getName()));

        assertEquals("Created tag should be identical to retrieved user",
                tag, tags.get(0));
    }
}

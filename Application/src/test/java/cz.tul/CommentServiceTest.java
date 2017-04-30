package cz.tul;

import cz.tul.data.Comment;
import cz.tul.data.Image;
import cz.tul.data.User;
import cz.tul.services.CommentService;
import cz.tul.services.ImageService;
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
public class CommentServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @Before
    public void init() {
        imageService.deleteAll();
        userService.deleteAll();
        commentService.deleteAll();
    }

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");

    private Image image1 = new Image(user1, "Sunrise","Path");
    private Image image2 = new Image(user1, "Wolf","Path");

    private Comment comment1 = new Comment(image1, user1, "Nice photo");
    private Comment comment2 = new Comment(image2, user1, "Another nice photo");
    private Comment comment3 = new Comment(image2, user2, "I dont thing so");

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);

        List<Comment> comments1 = commentService.getAll();
        assertEquals("One comment should have been created and retrieved.", 1, comments1.size());
        assertEquals("Inserted comment should match retrieved.", comment1, comments1.get(0));

        commentService.create(comment2);
        commentService.create(comment3);
        List<Comment> comments2 = commentService.getAll();
        assertEquals("Should be comment retrieved comments.", 3, comments2.size());
    }

    @Test
    public void testExists() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);
        assertTrue("Comment should exist.", commentService.exists(comment2));

        Comment comment4 = new Comment(image1, user2, "Another great comment!");
        assertFalse("Comment should not exist.", commentService.exists(comment4));
    }

    @Test
    public void testGet() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);
        Comment retrieved = commentService.get(comment2);
        assertEquals("Comment should match retrieved.", comment2, retrieved);
    }

    @Test
    public void testGetByImage() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        List<Comment> comments = commentService.getByImage(image2);
        assertNotNull("Retrieved comments should not be null.", comments);
        assertEquals("Retrieved comments should be 2 for this image.", 2, comments.size());
    }

    @Test
    public void testGetByAuthor() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        List<Comment> comments = commentService.getByAuthor(user1);
        assertNotNull("Retrieved comments should not be null.", comments);
        assertEquals("Retrieved comments should be 2 for this author.", 2, comments.size());
    }

    @Test
    public void testUpdate() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        comment2.setMessage("I changed my mind");
        commentService.update(comment2);

        Comment retrieved = commentService.get(comment2);
        assertEquals("Retrieved comment should be updated.", comment2, retrieved);
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        List<Comment> comments1 = commentService.getAll();
        assertEquals("All comments should have been created and retrieved.", 3, comments1.size());

        commentService.delete(comment1);
        commentService.delete(comment2);
        commentService.delete(comment3);

        List<Comment> comments2 = commentService.getAll();
        assertEquals("All comments should have been deleted.", 0, comments2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        imageService.create(image2);
        commentService.create(comment1);
        commentService.create(comment2);
        commentService.create(comment3);

        List<Comment> comments1 = commentService.getAll();
        assertEquals("All comments should have been created and retrieved.", 3, comments1.size());

        commentService.deleteAll();

        List<Comment> comments2 = commentService.getAll();
        assertEquals("All comments should have been deleted.", 0, comments2.size());
    }
}

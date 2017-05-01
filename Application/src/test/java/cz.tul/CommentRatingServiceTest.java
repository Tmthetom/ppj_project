package cz.tul;

import cz.tul.data.*;
import cz.tul.services.*;
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
public class CommentRatingServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRatingService commentRatingService;

    @Before
    public void init() {
        imageService.deleteAll();
        userService.deleteAll();
        commentService.deleteAll();
        commentRatingService.deleteAll();
    }

    private User user1 = new User("Tomas Moravec");
    private User user2 = new User("Pavel Malatny");

    private Image image1 = new Image(user1, "Sunrise","Path");

    private Comment comment = new Comment(image1, user1, "Nice photo");

    @Test
    public void testCreateRetrieve(){
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        commentService.create(comment);

        CommentRating comment_rating1 = new CommentRating(comment.getId_comment(), user2.getId_user(), Boolean.TRUE);
        commentRatingService.create(comment_rating1);

        List<CommentRating> comment_ratings1 = commentRatingService.getAll();
        assertEquals("One commentRating should have been created and retrieved.", 1, comment_ratings1.size());
        assertEquals("Inserted commentRatings should match retrieved.", comment_rating1, comment_ratings1.get(0));

        CommentRating comment_rating2 = new CommentRating(comment.getId_comment(), user1.getId_user(), Boolean.TRUE);
        commentRatingService.create(comment_rating2);

        List<CommentRating> comment_ratings2 = commentRatingService.getAll();
        assertEquals("Should be two retrieved commentRatings.", 2, comment_ratings2.size());
    }

    @Test
    public void testUpdate() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        commentService.create(comment);

        CommentRating comment_rating = new CommentRating(comment.getId_comment(), user2.getId_user(), Boolean.TRUE);
        commentRatingService.create(comment_rating);

        comment_rating.setRating(Boolean.FALSE);
        commentRatingService.update(comment_rating);

        CommentRating retrieved = commentRatingService.getCommentRatings(comment).get(0);
        assertEquals("Retrieved commentRating should be updated.", comment_rating, retrieved);
    }

    @Test
    public void testDelete() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        commentService.create(comment);

        CommentRating comment_rating = new CommentRating(comment.getId_comment(), user2.getId_user(), Boolean.TRUE);
        commentRatingService.create(comment_rating);

        List<CommentRating> comment_ratings1 = commentRatingService.getAll();
        assertEquals("All commentRatings should have been created and retrieved.", 1, comment_ratings1.size());

        commentRatingService.delete(comment_rating);

        List<CommentRating> comment_ratings2 = commentRatingService.getAll();
        assertEquals("All commentRatings should have been deleted.", 0, comment_ratings2.size());
    }

    @Test
    public void testDeleteAll() {
        userService.create(user1);
        userService.create(user2);
        imageService.create(image1);
        commentService.create(comment);

        CommentRating comment_rating = new CommentRating(comment.getId_comment(), user2.getId_user(), Boolean.TRUE);
        commentRatingService.create(comment_rating);

        List<CommentRating> comment_ratings1 = commentRatingService.getAll();
        assertEquals("All commentRatings should have been created and retrieved.", 1, comment_ratings1.size());

        commentRatingService.deleteAll();

        List<CommentRating> comment_ratings2 = commentRatingService.getAll();
        assertEquals("All commentRatings should have been deleted.", 0, comment_ratings2.size());
    }
}

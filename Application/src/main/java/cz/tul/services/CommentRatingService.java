package cz.tul.services;

import cz.tul.data.Comment;
import cz.tul.data.CommentRatingId;
import cz.tul.data.CommentRating;
import cz.tul.repositories.CommentRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommentRatingService {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    private CommentRatingRepository commentRatingRepository;

    public void create(CommentRating comment_rating) {
        commentRatingRepository.save(comment_rating);
    }

    public void update(CommentRating comment_rating){ commentRatingRepository.save(comment_rating); }

    public boolean exists(CommentRatingId commentRatingId) {
        return commentRatingRepository.exists(commentRatingId);
    }

    public List<CommentRating> getCommentRatings(Comment comment) {
        return commentRatingRepository.getCommentRatings(comment.getId_comment());
    }

    public List<CommentRating> getAll() {
        return StreamSupport.stream(commentRatingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(CommentRating comment_rating){
        commentRatingRepository.delete(comment_rating);
    }

    public void deleteAll() {
        commentRatingRepository.deleteAll();
    }
}

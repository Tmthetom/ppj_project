package cz.tul.services;

import cz.tul.data.Comment;
import cz.tul.data.CommentRatingId;
import cz.tul.data.Comment_Rating;
import cz.tul.repositories.CommentRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommentRatingService {

    @Autowired
    private CommentRatingRepository commentRatingRepository;

    public void create(Comment_Rating comment_rating) {
        commentRatingRepository.save(comment_rating);
    }

    public void update(Comment_Rating comment_rating){ commentRatingRepository.save(comment_rating); }

    public boolean exists(CommentRatingId commentRatingId) {
        return commentRatingRepository.exists(commentRatingId);
    }

    public List<Comment_Rating> getCommentRatings(Comment comment) {
        return commentRatingRepository.getCommentRatings(comment.getId_comment());
    }

    public List<Comment_Rating> getAll() {
        return StreamSupport.stream(commentRatingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(Comment_Rating comment_rating){
        commentRatingRepository.delete(comment_rating);
    }

    public void deleteAll() {
        commentRatingRepository.deleteAll();
    }
}

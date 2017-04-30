package cz.tul.services;

import cz.tul.data.Comment;
import cz.tul.data.Image;
import cz.tul.data.User;
import cz.tul.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void create(Comment comment) {
        commentRepository.save(comment);
    }

    public void update(Comment comment){ commentRepository.save(comment); }

    public boolean exists(Comment comment) {
        return commentRepository.exists(comment.getId_comment());
    }

    public Comment get(Comment comment) {
        return commentRepository.getComment(comment.getId_comment());
    }

    public List<Comment> getAll() {
        return StreamSupport.stream(commentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<Comment> getByImage(Image image) {
        return commentRepository.findByImage(image);
    }

    public List<Comment> getByAuthor(User author){
        return commentRepository.findByAuthor(author);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment.getId_comment());
    }

    public void deleteAll() {
        commentRepository.deleteAll();
    }
}

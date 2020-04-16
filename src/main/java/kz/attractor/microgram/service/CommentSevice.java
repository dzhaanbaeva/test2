package kz.attractor.microgram.service;

import kz.attractor.microgram.Model.Comment;
import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.dto.CommentDTO;
import kz.attractor.microgram.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentSevice {
    private final CommentRepository commentRepository;

    public CommentSevice(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDTO addComment(CommentDTO commentData) {

        Comment comment = Comment.builder()
                .publication(Publication.builder().id(commentData.getPublication()).build())
                .comment(commentData.getComment())
                .commentTime(commentData.getCommentTime())
                .build();


        commentRepository.save(comment);
        return CommentDTO.from(comment);
    }
    public Iterable<Comment> getComment() { return commentRepository.findAll(); }

    public boolean deleteComment(String commentId) {
        //TODO recalculate movie rating before delete
        commentRepository.deleteCommentById(commentId);
        return true;
    }

    public Optional<Comment> getComment(String id) {
        return commentRepository.findById(id);
    }

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }
    public Iterable<Comment> getPublication(String publication) {
        return commentRepository.selectPublication(publication);
    }

}

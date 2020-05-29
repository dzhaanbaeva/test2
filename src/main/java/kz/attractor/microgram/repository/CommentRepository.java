package kz.attractor.microgram.repository;

import kz.attractor.microgram.Model.Comment;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, String> {
    public List<Comment> findAll();

    public Iterable<Comment> deleteCommentById(String id);

    public Optional<Comment> findById(String id);

    public Iterable<Comment> findCommentsByPublicationId(String publication);
}

package kz.attractor.microgram.repository;

import kz.attractor.microgram.Model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, String> {
//    public List<Comment> findAllByPublicationId(String id);
}

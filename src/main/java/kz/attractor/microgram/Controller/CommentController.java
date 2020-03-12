package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.Comment;
import kz.attractor.microgram.Model.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepo;

    @DeleteMapping("/comment/{id}")
    public Comment deleteTask(@PathVariable String id) {
        Comment comment = commentRepo.findById(id).orElse(new Comment());
        commentRepo.deleteById(id);

        return comment;
    }

    @GetMapping("/comment/{id}")
    public Comment getTask(@PathVariable String id) {
        Comment comment = commentRepo.findById(id).orElse(new Comment());

        return comment;
    }
}

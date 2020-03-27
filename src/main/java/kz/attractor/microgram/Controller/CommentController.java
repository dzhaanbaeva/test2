package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.Comment;
import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.dto.CommentDTO;
import kz.attractor.microgram.dto.PublicationDTO;
import kz.attractor.microgram.service.CommentSevice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentSevice commentSevice;

    public CommentController(CommentSevice commentSevice) {
        this.commentSevice = commentSevice;
    }

    @GetMapping
    public Iterable<Comment> getComment() {
        return commentSevice.getComments();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommentDTO addComment(@RequestBody CommentDTO commentData) {
        return commentSevice.addComment(commentData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String id) {
        if (commentSevice.deleteComment(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/comment/{id}")
      public Iterable<Comment> getComment(@PathVariable("id") String id) {
        return commentSevice.getComments();
    }
}

package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.Comment;
import kz.attractor.microgram.dto.CommentDTO;
import kz.attractor.microgram.service.CommentSevice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public CommentDTO addComment(@RequestBody CommentDTO commentData) {
//        return commentSevice.addComment(commentData);
//    }

     @PostMapping
     public CommentDTO commentSave(
             @RequestParam("comment") String comment,
             @RequestParam("publication") String publication,
             @RequestParam("user") String user) throws IOException {
         System.out.println(publication);
         System.out.println(user);
         System.out.println(comment);
      CommentDTO comments;
         comments = new CommentDTO(comment, publication, user);
         commentSevice.addComment(comments);

    return comments;

}
    @GetMapping("/{publication}")
    public Iterable<Comment> selectPublication(@PathVariable("publication") String publication){
        return commentSevice.selectPublication(publication);
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

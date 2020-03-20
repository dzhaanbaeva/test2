package kz.attractor.microgram.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
//    @Autowired
//    private CommentRepository commentRepo;
//
//    @PostMapping("/user")
//    public Comment createUser(@RequestBody Comment comment){
//        Comment commentN = commentRepo.findById(comment.getId()).orElse(comment);
//        for (Publication t : comment.publications) {
//            if (userN.publications.stream().filter(x -> x.getId().equals(t.getId())).count() == 0)
//                userN.publications.add(t);
////        }
////
//            List<Publication> publications = userN.publications;
//            for (Publication t : publications)
//                publicationRepo.save(t);
//        }
//
//    @DeleteMapping("/comment/{id}")
//    public Comment deleteTask(@PathVariable String id) {
//        Comment comment = commentRepo.findById(id).orElse(new Comment());
//        commentRepo.deleteById(id);
//
//        return comment;
//    }
//
//    @GetMapping("/comment/{id}")
//    public Comment getTask(@PathVariable String id) {
//        Comment comment = commentRepo.findById(id).orElse(new Comment());
//
//        return comment;
//    }
}

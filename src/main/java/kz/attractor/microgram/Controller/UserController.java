package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private PublicationRepository publicationRepo;
    @Autowired
    private ILikeItRepository iLikeItRepo;
    @Autowired
    private UserSubscriptionsRepository userSubscriptionsRepo;


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        // merge
        User userN = userRepo.findById(user.id).orElse(user);
        for (Comment t : user.comments) {
            if (userN.comments.stream().filter(x -> x.id.equals(t.id)).count() == 0)
                userN.comments.add(t);
        }
        for (Publication t : user.publications) {
            if (userN.publications.stream().filter(x -> x.id.equals(t.id)).count() == 0)
                userN.publications.add(t);
        }

        List<Publication> publications = userN.publications;
        for (Publication t : publications)
            publicationRepo.save(t);

//        for (ILikeIt t : user.iLikeIts) {
//            if (userN.iLikeIts.stream().filter(x -> x.id.equals(t.id)).count() == 0)
//                userN.iLikeIts.add(t);
//        }
//
//        for (Publication t : user.comments) {
//            if (userN.comments.stream().filter(x -> x.id.equals(t.id)).count() == 0)
//                userN.comments.add(t);
//        }

        // save
        List<Comment> comments = userN.comments;
        for (Comment t : comments)
            commentRepo.save(t);

        userN.publicationCount = publications.size();

        userRepo.save(userN);
        return userN;
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable String id) {
        User user = userRepo.findById(id).orElse(new User());
        userRepo.deleteById(id);

        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        User user = userRepo.findById(id).orElse(new User());
        return user;
    }

}
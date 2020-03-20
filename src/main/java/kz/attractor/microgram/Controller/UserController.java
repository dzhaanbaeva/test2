package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.*;
import kz.attractor.microgram.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private CommentRepository CommentRepo;
    @Autowired
    private PublicationRepository PublicationRepo;
    @Autowired
    private ILikeItRepository ILikeItRepo;
    @Autowired
    private UserSubscriptionsRepository UserSubscriptionsRepo;


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        // merge
        User userN = UserRepo.findById(user.getId()).orElse(user);
        return userN;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        Sort s = Sort.by(Sort.Order.asc("name"));
        return UserRepo.findAll(s);
    }
    @GetMapping("/user/{name}")
    public User getName(@PathVariable("name") String name) {
        return UserRepo.findByName(name);
    }

    @GetMapping("/user/{email}")
    public boolean checkEmail(@PathVariable("email") String email) {
        return UserRepo.existsByEmail(email);
    }
//
//
//    @GetMapping("/watchPublication")
//    public Iterable<Publication> watchAllPublication() {
//        return publicationRepo.findAll();
//    }
//
//

}






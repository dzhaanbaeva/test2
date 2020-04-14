package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.*;

import kz.attractor.microgram.service.UserService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public UserDTO addEvent(@RequestBody UserDTO userData) {
//        return userService.addUser(userData);
//    }

    @GetMapping
    public Iterable<User> getEvents() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Iterable<User> getUser(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/name/{name}")
    public Optional<User> getName(@PathVariable("name") String name) {
        return userService.getName(name);
    }

    @GetMapping("/user/{email}")
    public boolean checkEmail(@PathVariable("email") String email) {
        return userService.existsEmail(email);
    }

    @GetMapping("/user/email/{email}")
    public Iterable<User> getEmail(@PathVariable("email") String email) {
        return userService.getEmail(email);
    }
//
//
//    @GetMapping("/demo")
//    public String demo(Model model) {
//        return "demo";
//    }
//
//    @PostMapping("/demo/post")
//    public String postDemo(@RequestParam("login") String login, @RequestParam("password") String password) {
//        System.out.println(login);
//        System.out.println(password);
//        return "redirect:/demo/";
//    }


}






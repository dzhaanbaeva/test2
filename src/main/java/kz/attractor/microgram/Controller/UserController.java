package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.*;
import kz.attractor.microgram.dto.UserDTO;
import kz.attractor.microgram.service.UserService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO addEvent(@RequestBody UserDTO userData) {
        return userService.addUser(userData);
    }

    @GetMapping
    public Iterable<User> getEvents() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Iterable<User> getUser(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<User> getName(@PathVariable("name") String name) {
        return userService.getName(name);
    }

    @GetMapping("/{email}")
    public boolean checkEmail(@PathVariable("email") String email) {
        return userService.existsEmail(email);
    }

    @GetMapping("/email/{email}")
    public Iterable<User> getEmail(@PathVariable("email") String email) {
        return userService.getEmail(email);
    }


}






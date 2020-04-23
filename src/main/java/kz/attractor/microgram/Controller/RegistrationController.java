package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository repo;


    @PostMapping("/registration")
    public User createComment(@RequestParam("email") String email, @RequestParam("name") String name,
                              @RequestParam("login") String login, @RequestParam("password") String password) {

        User person = new User(email, name, login, password);
        repo.save(person);

        return person;
    }

    @PostMapping("/login")
    public User makeLogin(@RequestParam("login") String login, @RequestParam("password") String password) {

        User person = repo.findByLogin(login).get();
        repo.save(person);

        return person;
    }

}

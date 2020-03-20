package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.UserSubscriptions;
import kz.attractor.microgram.repository.UserSubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSubscriptionsController {
    @Autowired
    private UserSubscriptionsRepository subscriptionsRepo;

    @DeleteMapping("/subscriptions/{id}")
    public UserSubscriptions deleteTask(@PathVariable String id) {
        UserSubscriptions subscriptions = subscriptionsRepo.findById(id).orElse(new UserSubscriptions());
        subscriptionsRepo.deleteById(id);

        return subscriptions;
    }

    @GetMapping("/subscriptions/{id}")
    public UserSubscriptions getTask(@PathVariable String id) {
        UserSubscriptions subscriptions = subscriptionsRepo.findById(id).orElse(new UserSubscriptions());

        return subscriptions;
    }
}

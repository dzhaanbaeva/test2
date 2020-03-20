package kz.attractor.microgram.repository;

import kz.attractor.microgram.Model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsByEmail(String email);
    User getByEmail(String email);
    public User findByName(String name);
    public Iterable<User> findAll(Sort s);

}
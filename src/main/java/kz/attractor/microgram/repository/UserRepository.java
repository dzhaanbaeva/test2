package kz.attractor.microgram.repository;

import kz.attractor.microgram.Model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsByEmail(String email);
    public  Iterable<User> getByEmail(String email);
    public  Optional<User> findByUsername(String name);
    public Iterable<User> findAll();
    public Iterable<User> getUserById(String id);
    public Optional<User> findAllByEmail(String s);

}
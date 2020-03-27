package kz.attractor.microgram.service;

import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.dto.UserDTO;
import kz.attractor.microgram.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDTO addUser(UserDTO UserData) {

        var user = User.builder()
                .username(UserData.getUsername())
                .email(UserData.getEmail())
                .password(UserData.getPassword())
                .build();

        userRepository.save(user);
        return UserDTO.from(user);
    }
    public Iterable<User> getUsers() { return userRepository.findAll(); }

    public Optional<User> getName(String name) {
        return userRepository.findByUsername(name);
    }
    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public Iterable<User> getEmail(String email) {
        return  userRepository.getByEmail(email);
    }
    public Iterable<User> getUserById(String id) { return userRepository.getUserById(id); }



}

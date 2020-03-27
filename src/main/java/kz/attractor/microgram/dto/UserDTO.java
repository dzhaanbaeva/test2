package kz.attractor.microgram.dto;

import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {

    public static UserDTO from(User user) {


        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }



    private String id = UUID.randomUUID().toString();
    public String username;
    public String email;
    public String password;
    public int publicationCount = 0;
    public int subscriptionsCount = 0;
    public int subscribersCount = 0;
    @DBRef
    public List<Publication> publications = new ArrayList<>();
    @DBRef
    public List<User> subscriptions = new ArrayList<>();
    @DBRef
    public List<User> subscribers = new ArrayList<>();

}


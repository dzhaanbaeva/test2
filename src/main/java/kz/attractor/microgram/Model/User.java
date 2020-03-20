package kz.attractor.microgram.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import kz.attractor.microgram.util.Generator;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "users")
@CompoundIndex(def = "{'name':1, 'email':1}")
@Data
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    public String name;
    public String email;
    public String password;
    //    public int publicationCount = 0;
//    public int subscriptionsCount = 0;
//    public int subscribersCount = 0;
//    @DBRef
//    public Publication publication;
//    @DBRef
//    public List<String> subscriptionsId = new ArrayList<>();
//    @DBRef
//    public List<String> subscribersId = new ArrayList<>();

    public static User random() {
        return builder()
                .name(Generator.makeName())
                .email(Generator.makeEmail())
                .password(Generator.makePassword())
                .build();
    }
}






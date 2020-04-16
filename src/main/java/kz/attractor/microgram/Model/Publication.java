package kz.attractor.microgram.Model;

import kz.attractor.microgram.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Document(collection = "publications")
@Data
@Builder
@AllArgsConstructor
public class Publication {
    private static final Random r = new Random();

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    public  String image;
    public  String description;
    public LocalDateTime dateTime = LocalDateTime.now();

    @DBRef
    public User user;

//    public Publication(String user, String description, String images) {
//        Objects.requireNonNull(description);
//        Objects.requireNonNull(images);
////        this.id = String.valueOf(description.hashCode()); //UUID.randomUUID().toString();
//
//    }

//    @DBRef
//    public Comment comment;

    public static Publication random(User user) {
        return builder()
                .user(user)
                .description(Generator.makeDescription())
//                .comment(comment)
                .build();
    }

}

package kz.attractor.microgram.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "iLikeIt")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ILikeIt {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;

    public LocalDateTime likeTime;

    @DBRef
    private Publication publication;

    public static ILikeIt random(User user, Publication publication) {
        return builder()
                .user(user)
                .likeTime(LocalDateTime.now())
                .publication(publication)
                .build();
    }
}

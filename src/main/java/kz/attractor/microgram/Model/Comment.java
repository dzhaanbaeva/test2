package kz.attractor.microgram.Model;

import kz.attractor.microgram.repository.PublicationRepository;
import kz.attractor.microgram.util.Generator;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Document(collection = "comments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Comment{
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();


    public String comment;
    @DBRef
    public Publication publication;
    @DBRef
    public User user;
    public LocalDateTime commentTime;
}
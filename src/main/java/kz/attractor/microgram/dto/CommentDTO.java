package kz.attractor.microgram.dto;

import kz.attractor.microgram.Model.Comment;
import kz.attractor.microgram.Model.Publication;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDTO {

    public CommentDTO(String comment, String publication, String user) {
        this.comment = comment;
        this.publication = publication;
        this.user = user;


    }

    public static CommentDTO from(Comment comment) {

        return builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .publication(comment.getPublication().getId())
                .user(comment.getUser().getId())
                .commentTime(LocalDateTime.now())
                .build();


    }

    public String id;
    public String comment;
    public String publication;
    public String user;
    public LocalDateTime commentTime = LocalDateTime.now();

}

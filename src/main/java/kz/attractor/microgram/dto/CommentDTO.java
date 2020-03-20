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

    public  CommentDTO from(Comment comment) {

        return builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .publicationId(publicationId)
                .commentTime(LocalDateTime.now())
                .build();
    }

    public String id;
    public String comment;
    private Publication publicationId;
    public LocalDateTime commentTime = LocalDateTime.now();

}

package kz.attractor.microgram.dto;

import kz.attractor.microgram.Model.User;
import lombok.*;
import kz.attractor.microgram.Model.ILikeIt;
import kz.attractor.microgram.Model.Publication;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PublicationDTO {


    public PublicationDTO(String description, String image, String user) {
        this.description = description;
        this.image = image;
        this.user = user;

    }

    public static PublicationDTO from(Publication publication) {

        return builder()
                .id(publication.getId())
                .image(publication.getImage())
                .description(publication.getDescription())
                .user(publication.getUser().getId())
                .dateTime(LocalDateTime.now())
                .build();

    }

    private String id = UUID.randomUUID().toString();
    public String image;
    public String description;
    public String user;
    public LocalDateTime dateTime = LocalDateTime.now();


}

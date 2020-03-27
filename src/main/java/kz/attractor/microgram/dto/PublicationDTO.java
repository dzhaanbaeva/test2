package kz.attractor.microgram.dto;
import  lombok.*;
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

    public static PublicationDTO from(Publication publication) {

        return builder()
                .id(publication.getId())
                .images(publication.getImages())
                .description(publication.getDescription())
                .userId(publication.getUser().getId())
                .dateTime(LocalDateTime.now())
                .build();

    }

    private String id = UUID.randomUUID().toString();
    public  String images;
    public  String description;
    public String userId;
    public LocalDateTime dateTime = LocalDateTime.now();



}

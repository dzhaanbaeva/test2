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

    public  PublicationDTO from(Publication publication) {

        return builder()
                .id(publication.getId())
                .images(publication.getImages())
                .description(publication.getDescription())
                .dateTime(LocalDateTime.now())
                .build();
    }

    private String id = UUID.randomUUID().toString();
    public  String images;
    public  String description;
    public LocalDateTime dateTime = LocalDateTime.now();

}

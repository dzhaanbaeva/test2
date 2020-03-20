package kz.attractor.microgram.dto;


import kz.attractor.microgram.Model.ILikeIt;
import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
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
public class ILikeItDTO {

    public  ILikeItDTO from(ILikeIt likeIt) {

        return builder()
                .id(likeIt.getId())
                .user(user)
                .likeTime(LocalDateTime.now())
                .publication(publication)
                .build();
    }



    @Id
    public String id;
    private String user;
    public LocalDateTime likeTime;
    public String publication;

}


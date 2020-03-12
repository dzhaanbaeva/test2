package kz.attractor.microgram.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class UserSubscriptions {

    @Id
    @Getter
    @Setter
    public String id;
    @Getter
    @Setter
    public  String userIdr1;
    @Getter
    @Setter
    public String userId2;
    @Getter
    @Setter
    public LocalDateTime eventsDate;


}

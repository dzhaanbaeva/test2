package kz.attractor.microgram.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "publications")
@Data
public class Publication {

    @Id
    @Getter
    @Setter
    public  String id;
    @Getter
    @Setter
    public  String images;
    @Getter
    @Setter
    public  String description;
    @Getter
    @Setter
    public LocalDateTime dateTime = LocalDateTime.now();


}

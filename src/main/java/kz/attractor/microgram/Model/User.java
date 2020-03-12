package kz.attractor.microgram.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
@CompoundIndex(def = "{'name':1, 'email':1}")
@Data
public class User {
    @Id
    @Getter
    @Setter
    public String id;
    @Getter
    @Setter
    public String name;
    @Getter
    @Setter
    public String email;
    @Getter
    @Setter
    public String password;
    @Getter
    @Setter
    public int publicationCount = 0;
    @Getter
    @Setter
    public int subscriptionsCount = 0;
    @Getter
    @Setter
    public int subscribersCount = 0;
    @DBRef
    @Getter
    @Setter
    public List<Comment> comments = new ArrayList<>();
    public List<Publication> publications = new ArrayList<>();
//    public List<ILikeIt> iLikeIts = new ArrayList<>();
//    public List<UserSubscriptions> userSubscriptions = new ArrayList<>();

  }

package kz.attractor.microgram.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import kz.attractor.microgram.util.Generator;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Document(collection = "users")
@CompoundIndex(def = "{'name':1, 'email':1}")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class User implements UserDetails{

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    public String username;
    public String email;
    public String password;
    //    public int publicationCount = 0;
//    public int subscriptionsCount = 0;
//    public int subscribersCount = 0;
//    @DBRef
//    public Publication publication;
//    @DBRef
//    public List<String> subscriptionsId = new ArrayList<>();
//    @DBRef
//    public List<String> subscribersId = new ArrayList<>();

    public static User random() {
        return builder()
                .username(Generator.makeName())
                .email(Generator.makeEmail())
                .password(Generator.makePassword())
                .build();
    }




    @Override
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority>
    getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}






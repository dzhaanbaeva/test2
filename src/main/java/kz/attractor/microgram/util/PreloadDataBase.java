package kz.attractor.microgram.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.attractor.microgram.Model.*;
import kz.attractor.microgram.repository.CommentRepository;
import kz.attractor.microgram.repository.ILikeItRepository;
import kz.attractor.microgram.repository.PublicationRepository;
import kz.attractor.microgram.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Configuration
public class PreloadDataBase {

    private static final Random r = new Random();


    @Bean
    CommandLineRunner usersInit(UserRepository userRepo, PublicationRepository publicationRepo, CommentRepository commentRepo, ILikeItRepository likeRepo) {
        return (args) -> {
            userRepo.deleteAll();
            publicationRepo.deleteAll();
            commentRepo.deleteAll();
//            likeRepo.deleteAll();
//
            List<User> users = new ArrayList<>();
            users.add(new User("ainura@gmail.com", "ainura", "dzhainura", "123"));
            users.add(new User("user@gmail.com", "user", "testuser", "452"));
            userRepo.saveAll(users);


            List<Publication> publications = new ArrayList<>();
            publications.add(new Publication("1", null, "nature", LocalDateTime.now(), users.get(0)));
            publications.add(new Publication("2", null, "Good", LocalDateTime.now(), users.get(1)));
            publicationRepo.saveAll(publications);
//            List<Comment> comments = readMovies("comments.json");

            List<Comment> comments = new ArrayList<>();
            comments.add(new Comment("1", "Coool", publications.get(0), users.get(1), LocalDateTime.now()));
            comments.add(new Comment("1", "Nice picture", publications.get(1), users.get(0), LocalDateTime.now()));
            commentRepo.saveAll(comments);
            List<ILikeIt> likes = new ArrayList<>();


//            users.forEach(user -> {
//                selectRandomMovies(comments, r.nextInt(1) + 1).stream()
//                        .map(comment -> Publication.random(user))
//                        .peek(publications::add)
//                        .forEach(publicationRepo::save);
//            });
//            commentRepo.saveAll(comments);

//            users.forEach(user -> {
//                selectRandomRepo(publications, r.nextInt(3) + 1).stream()
//                        .map(pub -> ILikeIt.random(user, pub))
//                        .peek(likes::add)
//                        .forEach(likeRepo::save);
//            });
//
//            likeRepo.saveAll(likes);
        };

    }

//    private List<Comment> selectRandomMovies(List<Comment> movies, int amountOfMovies) {
//        return Stream.generate(() -> pickRandom(movies))
////                .distinct()
//                .limit(amountOfMovies)
//                .collect(toList());
//    }
//    private List<Publication> selectRandomRepo(List<Publication> repo, int amountOfMovies) {
//        return Stream.generate(() -> pickRnd(repo))
//                .distinct()
//                .limit(amountOfMovies)
//                .collect(toList());
//    }
//
//    private static Comment pickRandom(List<Comment> movies) {
//        return movies.get(r.nextInt(movies.size()));
//    }
//    private static Publication pickRnd(List<Publication> likes) {
//        return likes.get(r.nextInt(likes.size()));
//    }
//
//    private static List<Comment> readMovies(String fileName) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            var data = Files.readString(Paths.get(fileName));
//            var listType = new TypeReference<List<Comment>>() {
//            };
//            return mapper.readValue(data, listType);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return List.of();
//    }
}





package kz.attractor.microgram.service;

import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.dto.PublicationDTO;
import kz.attractor.microgram.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final UserService userService;

    public PublicationService(PublicationRepository publicationRepository, UserService userService) {
        this.publicationRepository = publicationRepository;
        this.userService = userService;
    }

    public PublicationDTO addPublication(PublicationDTO publicationData) {

        Publication publication = Publication.builder()
                .image(publicationData.getImage())
                .description(publicationData.getDescription())
                .user(User.builder().id(publicationData.getUser()).build())
                .dateTime(LocalDateTime.now())
                .build();


        publicationRepository.save(publication);
        return PublicationDTO.from(publication);
    }

    public Iterable<Publication> getPublication() {
        return publicationRepository.findAll();
    }

    public Iterable<Publication> selectPublicationsByUserId(String id) {
        return publicationRepository.findPublicationsByUserId(id);
    }

    public boolean deletePub(String id) {
        //TODO recalculate movie rating before delete
        publicationRepository.deletePublicationById(id);
        return true;

//    public Iterable<Publication> selectPublicationsById(String id) {
//        return publicationRepository.findPublicationsById(id);
//    }


    }
}

package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
import kz.attractor.microgram.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PublicationController {
    @Autowired
    private PublicationRepository publicationRepo;

    @GetMapping("/publication")
    public Iterable<Publication> getPublication() {
        return publicationRepo.findAll();
    }

    @GetMapping("/publication/{user}")
    public Iterable<Publication> selectPublication(@PathVariable("user") String user){
        return publicationRepo.selectPublication(user);
    }


}

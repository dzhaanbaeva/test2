package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationController {
    @Autowired
    private PublicationRepository publicationRepo;

    @DeleteMapping("/publication/{id}")
    public Publication deleteTask(@PathVariable String id) {
        Publication publication = publicationRepo.findById(id).orElse(new Publication());
        publicationRepo.deleteById(id);

        return publication;
    }

    @GetMapping("/publication/{id}")
    public Publication getTask(@PathVariable String id) {
        Publication publication = publicationRepo.findById(id).orElse(new Publication());

        return publication;
    }
}

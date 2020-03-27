package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.dto.PublicationDTO;
import kz.attractor.microgram.dto.UserDTO;
import kz.attractor.microgram.service.PublicationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PublicationDTO addPublication(@RequestBody PublicationDTO publicationData) {
        return publicationService.addPublication(publicationData);
    }

    @GetMapping
    public Iterable<Publication> getPublications() {
        return publicationService.getPublication();
    }

    @GetMapping("/{id}")
    public Iterable<Publication> selectPublications(@PathVariable("id") String id){
        return publicationService.selectPublicationsByUserId(id);
    }
    @GetMapping("/id/{id}")
    public Iterable<Publication> selectPublication(@PathVariable("id") String id){
        return publicationService.selectPublicationsById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable String id) {
        if (publicationService.deletePub(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }



}

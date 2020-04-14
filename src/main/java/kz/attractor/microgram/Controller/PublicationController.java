package kz.attractor.microgram.Controller;


import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.dto.PublicationDTO;
import kz.attractor.microgram.repository.PublicationRepository;
import kz.attractor.microgram.service.PublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public Iterable<Publication> getPublications() {
        return publicationService.getPublication();
    }

    @PostMapping
    public PublicationDTO rootSave(
                           @RequestParam("description") String description,
                           @RequestParam("user") String user,
                           @RequestParam("images") MultipartFile images
                           ) throws IOException {
        File photoFile = new File("src/main/resources/static/images/"+ images.getOriginalFilename());
//        photoFile.createNewFile();
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(images.getBytes());
        os.close();

        PublicationDTO publication;
        publication = new PublicationDTO(description, images.getOriginalFilename(),user);
        publicationService.addPublication(publication);

        return publication;
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

//    @GetMapping("/demo/getUser")
//    public Map<String, Object> getUser() {
//        return this.userMap;
//    }




}

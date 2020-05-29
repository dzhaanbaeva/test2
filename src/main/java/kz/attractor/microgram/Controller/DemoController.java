package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.dto.PublicationDTO;
import kz.attractor.microgram.repository.PublicationRepository;
import kz.attractor.microgram.service.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class DemoController {
    private final PublicationService publicationService;
    private final PublicationRepository repository;

    public DemoController(PublicationService publicationService, PublicationRepository repository) {
        this.publicationService = publicationService;
        this.repository = repository;
    }

    @GetMapping("/")
    public String demo(Model model) {
        return "demo";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        return "posts";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


}

package kz.attractor.microgram.Controller;

import kz.attractor.microgram.Model.ILikeIt;
import kz.attractor.microgram.Model.ILikeItRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ILikeItController {
    @Autowired
    private ILikeItRepository likeRepo;

    @DeleteMapping("/like/{id}")
    public ILikeIt deleteTask(@PathVariable String id) {
        ILikeIt like = likeRepo.findById(id).orElse(new ILikeIt());
        likeRepo.deleteById(id);

        return like;
    }

    @GetMapping("/like/{id}")
    public ILikeIt getTask(@PathVariable String id) {
        ILikeIt like = likeRepo.findById(id).orElse(new ILikeIt());

        return like;
    }
}

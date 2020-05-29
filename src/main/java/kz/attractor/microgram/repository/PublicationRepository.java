package kz.attractor.microgram.repository;

import kz.attractor.microgram.Model.Publication;
import kz.attractor.microgram.Model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublicationRepository extends CrudRepository<Publication, String> {
    public Optional<Publication> findById(String id);

    public Iterable<Publication> findAll();

    @Query("{'user': {'$regex' : '?0' , '$options' : 'm'}}")
    public Iterable<Publication> selectPublication(String id);

    public Iterable<Publication> findPublicationsByUserId(String id);

    public Iterable<Publication> deletePublicationById(String id);

    public Iterable<Publication> findPublicationsById(String id);
}

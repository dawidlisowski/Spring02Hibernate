package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") Long id){
        return publisherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return publisherRepository.save(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Long id,
                                                     @RequestBody Publisher publisher){
        Optional<Publisher> maybePublisher = publisherRepository.findById(id);
        if(maybePublisher.isPresent()){
            Publisher updatedPublisher = maybePublisher.get();
            updatedPublisher.setName(publisher.getName());
            updatedPublisher.setAddress(publisher.getAddress());
            updatedPublisher.setCity(publisher.getCity());
            updatedPublisher.setZipCode(publisher.getZipCode());

            return ResponseEntity.ok(publisherRepository.save(updatedPublisher));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable("id") Long id){
        publisherRepository.deleteById(id);
    }
}

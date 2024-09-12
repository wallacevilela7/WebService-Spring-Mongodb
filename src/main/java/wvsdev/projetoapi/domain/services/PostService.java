package wvsdev.projetoapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wvsdev.projetoapi.domain.entities.Post;
import wvsdev.projetoapi.domain.repositories.PostRepository;
import wvsdev.projetoapi.domain.services.exception.ObjectNotFoundException;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
        maxDate = maxDate.plus(Duration.ofDays(1));
        return repository.fullSearch(text, minDate, maxDate);
    }
}

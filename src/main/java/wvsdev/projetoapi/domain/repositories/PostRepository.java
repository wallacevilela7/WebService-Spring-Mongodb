package wvsdev.projetoapi.domain.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import wvsdev.projetoapi.domain.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}

package wvsdev.projetoapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import wvsdev.projetoapi.domain.dto.AuthorDTO;
import wvsdev.projetoapi.domain.entities.Post;
import wvsdev.projetoapi.domain.entities.User;
import wvsdev.projetoapi.domain.repositories.PostRepository;
import wvsdev.projetoapi.domain.repositories.UserRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));


        Post p1 = new Post(null, Instant.parse("2024-03-21T21:53:07Z"), "Partiu viagem", "Vou viajar para Sao Paulo. Abraços!", new AuthorDTO(maria));

        Post p2 = new Post(null, Instant.parse("2024-03-21T23:13:45Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }
}

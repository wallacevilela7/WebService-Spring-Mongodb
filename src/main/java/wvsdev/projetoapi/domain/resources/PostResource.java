package wvsdev.projetoapi.domain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wvsdev.projetoapi.domain.entities.Post;
import wvsdev.projetoapi.domain.resources.util.URL;
import wvsdev.projetoapi.domain.services.PostService;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {

        text = URL.decodeParam(text);

        Instant min = URL.convertInstant(minDate, Instant.EPOCH); // data mínima padrão
        Instant max = URL.convertInstant(maxDate, Instant.now()); // data máxima padrão

        List<Post> list = service.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }
}

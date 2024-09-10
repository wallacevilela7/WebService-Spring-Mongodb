package wvsdev.projetoapi.domain.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wvsdev.projetoapi.domain.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user = new User("1","maria helena","maria@email");
        User user2 = new User("2","maria cursi","cursi@email");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user, user2));
        return ResponseEntity.ok().body(list);
    }
}

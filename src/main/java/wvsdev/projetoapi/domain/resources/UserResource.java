package wvsdev.projetoapi.domain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wvsdev.projetoapi.domain.dto.UserDTO;
import wvsdev.projetoapi.domain.entities.User;
import wvsdev.projetoapi.domain.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto =
                list
                        .stream()
                        .map(x -> new UserDTO(x))
                        .toList();
        return ResponseEntity.ok().body(listDto);
    }
}

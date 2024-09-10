package wvsdev.projetoapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wvsdev.projetoapi.domain.dto.UserDTO;
import wvsdev.projetoapi.domain.entities.User;
import wvsdev.projetoapi.domain.repositories.UserRepository;
import wvsdev.projetoapi.domain.services.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDTo(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}

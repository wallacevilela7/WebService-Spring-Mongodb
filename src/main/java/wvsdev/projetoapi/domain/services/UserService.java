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

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDto(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}

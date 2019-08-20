package com.joaomedeiros.workshopmongo.services;

import com.joaomedeiros.workshopmongo.domain.User;
import com.joaomedeiros.workshopmongo.dto.UserDTO;
import com.joaomedeiros.workshopmongo.repository.UserRepository;
import com.joaomedeiros.workshopmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to call repository data for Users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(final String id) {
        Optional<User> user = repo.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(final User obj) {
        return repo.insert(obj);
    }

    public void delete(final String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(final User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);

        return repo.save(newObj);
    }

    private void updateData(final User newObj, final User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(final UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

}

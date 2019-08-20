package com.joaomedeiros.workshopmongo.resources;

import com.joaomedeiros.workshopmongo.domain.Post;
import com.joaomedeiros.workshopmongo.domain.User;
import com.joaomedeiros.workshopmongo.dto.UserDTO;
import com.joaomedeiros.workshopmongo.services.UserService;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST controller with all the necessary operations for Post.
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        final List<User> all = service.findAll();
        final List<UserDTO> listDto = all.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable final String id) {
        final User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody final UserDTO objDTO) {
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> insert(@PathVariable final String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @RequestBody final UserDTO objDTO) {
        User obj = service.fromDTO(objDTO);
        obj.setId(id);

        service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}/posts", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable final String id) {
        final User obj = service.findById(id);

        return ResponseEntity.ok().body(obj.getPosts());
    }

}

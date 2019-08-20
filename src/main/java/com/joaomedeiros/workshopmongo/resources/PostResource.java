package com.joaomedeiros.workshopmongo.resources;

import com.joaomedeiros.workshopmongo.domain.Post;
import com.joaomedeiros.workshopmongo.domain.User;
import com.joaomedeiros.workshopmongo.dto.UserDTO;
import com.joaomedeiros.workshopmongo.resources.util.URL;
import com.joaomedeiros.workshopmongo.services.PostService;
import com.joaomedeiros.workshopmongo.services.UserService;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST controller with all the necessary operations for Post.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable final String id) {
        final Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/titlesearch", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value="text", defaultValue = "") final String text) {
        final String decodedText = URL.decodeParam(text);
        final List<Post> obj = service.findByTitle(decodedText);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/fullsearch", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue = "") final String text,
            @RequestParam(value="minDate", defaultValue = "") final String minDate,
            @RequestParam(value="maxDate", defaultValue = "") final String maxDate) {
        final String decodedText = URL.decodeParam(text);
        final Date min = URL.convertDate(minDate, new Date(0L));
        final Date max = URL.convertDate(maxDate, new Date());

        final List<Post> obj = service.fullSearch(decodedText, min, max);

        return ResponseEntity.ok().body(obj);
    }

}

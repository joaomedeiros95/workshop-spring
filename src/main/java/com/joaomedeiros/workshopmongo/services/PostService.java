package com.joaomedeiros.workshopmongo.services;

import com.joaomedeiros.workshopmongo.domain.Post;
import com.joaomedeiros.workshopmongo.repository.PostRepository;
import com.joaomedeiros.workshopmongo.services.exception.ObjectNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to call repository data for Posts.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(final String id) {
        Optional<Post> user = repo.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(final String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(final String text, final Date minDate, final Date maxDate) {
        final Date newDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

        return repo.fullSearch(text, minDate, newDate);
    }

}

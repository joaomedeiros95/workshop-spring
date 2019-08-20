package com.joaomedeiros.workshopmongo.config;

import com.joaomedeiros.workshopmongo.domain.Post;
import com.joaomedeiros.workshopmongo.domain.User;
import com.joaomedeiros.workshopmongo.dto.AuthorDTO;
import com.joaomedeiros.workshopmongo.dto.CommentDTO;
import com.joaomedeiros.workshopmongo.repository.PostRepository;
import com.joaomedeiros.workshopmongo.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import static com.joaomedeiros.workshopmongo.Defaults.SDF;

/**
 * This class will create initial data on the database.
 *
 * @author joaomedeiros
 */
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(final String... args) throws Exception {
        // Delete all existent data
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Create users on database
        final User maria = new User(null, "Maria Brown", "maria@gmail.com");
        final User alex = new User(null, "Alex Green", "alex@gmail.com");
        final User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        // Create posts and comments
        final Post post1 = new Post(null, SDF.parse("21/03/2018"), "Let's travel!", "Let's go to NYC", new AuthorDTO(maria));
        final Post post2 = new Post(null, SDF.parse("23/03/2018"), "Good morning!", "Woke up happy today", new AuthorDTO(maria));

        final CommentDTO comment1 = new CommentDTO("Have a great trip!", SDF.parse("21/03/2018"), new AuthorDTO(alex));
        final CommentDTO comment2 = new CommentDTO("Enjoy!", SDF.parse("22/03/2018"), new AuthorDTO(bob));
        final CommentDTO comment3 = new CommentDTO("Have a great day!", SDF.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        // add posts that maria wrote
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}

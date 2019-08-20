package com.joaomedeiros.workshopmongo.repository;

import com.joaomedeiros.workshopmongo.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository with custom queries for Posts.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{$and: [{date: {$gte: ?1}}, {date: {$lte: ?2}}, {$or: [{'title': { $regex: ?0, $options: 'i' }}, {'body': { $regex: ?0, $options: 'i' }}, {'comments.text': { $regex: ?0, $options: 'i' }}]}]}")
    List<Post> fullSearch(final String text, final Date minDate, final Date maxDate);

}

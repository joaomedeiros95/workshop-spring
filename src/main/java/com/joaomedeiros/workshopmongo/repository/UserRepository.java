package com.joaomedeiros.workshopmongo.repository;

import com.joaomedeiros.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Users.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

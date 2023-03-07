package com.mech_store.mech_store.repository;

import com.mech_store.mech_store.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

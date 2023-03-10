package com.mech_store.mech_store.repository;

import com.mech_store.mech_store.collection.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Products, String> {
}

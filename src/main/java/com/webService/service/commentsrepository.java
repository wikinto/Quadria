package com.webService.service;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface commentsrepository extends CrudRepository<comments, Integer> {

}
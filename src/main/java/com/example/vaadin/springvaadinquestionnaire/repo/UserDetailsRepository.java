package com.example.vaadin.springvaadinquestionnaire.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vaadin.springvaadinquestionnaire.entity.UserDetails;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

}

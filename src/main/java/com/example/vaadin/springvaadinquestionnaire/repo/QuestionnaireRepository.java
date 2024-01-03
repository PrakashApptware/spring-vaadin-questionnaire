package com.example.vaadin.springvaadinquestionnaire.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vaadin.springvaadinquestionnaire.entity.Questionnaire;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {

}


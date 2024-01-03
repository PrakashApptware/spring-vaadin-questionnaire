package com.example.vaadin.springvaadinquestionnaire.main;

import com.example.vaadin.springvaadinquestionnaire.entity.Questionnaire;
import com.example.vaadin.springvaadinquestionnaire.entity.UserDetails;
import com.example.vaadin.springvaadinquestionnaire.repo.QuestionnaireRepository;
import com.example.vaadin.springvaadinquestionnaire.repo.UserDetailsRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@Route
@SpringComponent
@UIScope
public class MainUI extends VerticalLayout {
	// private final QuestionnaireRepository questionnaireRepository;
	private final UserDetailsRepository userDetRepo;
	private final Grid<Questionnaire> grid = new Grid<>(Questionnaire.class);
	private final Grid<UserDetails> usergrid = new Grid<>(UserDetails.class);
	private final TextField firstName = new TextField("First Name");
	private final TextField lastName = new TextField("Last Name");
	private final TextField skills = new TextField("Skills");
	private final TextField experience = new TextField("Experience");
	private final TextField age = new TextField("Age");
	private final Button saveButton = new Button("Save");

	public MainUI(/* QuestionnaireRepository questionnaireRepository, */ UserDetailsRepository userDetRepo) {
		//this.questionnaireRepository = questionnaireRepository;
		this.userDetRepo = userDetRepo;
		
		
		usergrid.setColumns("id", "firstName", "lastName", "age", "experience", "skills");

		// grid.setColumns("id", "title", "description");
	//	grid.setItems(questionnaireRepository.findAll());
		
		usergrid.setItems(userDetRepo.findAll());
		saveButton.addClickListener(e -> saveUserDetails());

		add(firstName, lastName, skills, experience, age, saveButton, usergrid);
	}

	/*
	 * private void saveQuestionnaire() { Questionnaire questionnaire = new
	 * Questionnaire(); questionnaire.setTitle(titleField.getValue());
	 * questionnaire.setDescription(descriptionField.getValue());
	 * questionnaireRepository.save(questionnaire);
	 * 
	 * grid.setItems(questionnaireRepository.findAll()); clearFields(); }
	 */

	private void saveUserDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName.getValue());
		userDetails.setLastName(lastName.getValue());
		userDetails.setAge(age.getValue());
		userDetails.setExperience(experience.getValue());
		userDetails.setSkills(skills.getValue());
		userDetRepo.save(userDetails);

		usergrid.setItems(userDetRepo.findAll());
		clearFields();
	}

	private void clearFields() {
		firstName.clear();
		lastName.clear();
		age.clear();
		experience.clear();
		skills.clear();
	}

}

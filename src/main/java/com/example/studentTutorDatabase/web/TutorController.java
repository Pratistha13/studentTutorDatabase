package com.example.studentTutorDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.studentTutorDatabase.domain.Tutor;
import com.example.studentTutorDatabase.domain.TutorRepository;
import com.example.studentTutorDatabase.domain.DepartmentRepository;


@Controller
public class TutorController {
	@Autowired
	TutorRepository repository;

	@Autowired
	DepartmentRepository drepository;

	// home page
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	// log in
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// list page
	@RequestMapping(value = "/list")
	public String tutorList(Model model) {
		model.addAttribute("tutors", repository.findAll());
		return "tutorlist";

	}

	// Restful service to get all tutors
	@RequestMapping(value = "/tutors")
	public @ResponseBody List<Tutor> tutorListRest() {
		return (List<Tutor>) repository.findAll();
	}

	// Restful service to get tutor by id
	@RequestMapping(value = "/tutor/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Tutor> findTutorRest(@PathVariable("id") Long tutorId) {
		return repository.findById(tutorId);
	}

	// add new tutor
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTutor(Model model) {
		model.addAttribute("tutor", new Tutor());
		model.addAttribute("departments", drepository.findAll());
		return "addTutor";
	}

	// submitPage
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveTutor(Tutor tutor, Model model) {
		model.addAttribute("tutor", repository.save(tutor));
		return "redirect:list";
	}

	// edit tutor
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editTutor(@PathVariable("id") Long tutorId, Model model) {
		model.addAttribute("tutor", repository.findById(tutorId));
		model.addAttribute("departments", drepository.findAll());
		return "editTutor";
	}

	// delete tutor
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTutor(@PathVariable("id") Long tutorId, Model model) {
		repository.deleteById(tutorId);
		return "redirect:../list";
	}

}
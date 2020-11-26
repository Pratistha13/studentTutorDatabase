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

import com.example.studentTutorDatabase.domain.DepartmentRepository;
import com.example.studentTutorDatabase.domain.Student;
import com.example.studentTutorDatabase.domain.StudentRepository;


@Controller
public class StudentController {
	@Autowired
	StudentRepository srepository;

	@Autowired
	DepartmentRepository drepository;

	// list page
	@RequestMapping(value = "/stlist")
	public String studentList(Model model) {
		model.addAttribute("students", srepository.findAll());
		return "studentlist";

	}

	// Restful service to get all students
	@RequestMapping(value = "/students")
	public @ResponseBody List<Student> studentListRest() {
		return (List<Student>) srepository.findAll();
	}

	// Restful service to get student by id
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Student> findStudentRest(@PathVariable("id") Long studentId) {
		return srepository.findById(studentId);
	}

	// add new student
	@RequestMapping(value = "/addst", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("departments", drepository.findAll());
		return "addStudent";
	}

	// submitPage
	@RequestMapping(value = "/submitstudent", method = RequestMethod.POST)
	public String saveStudent(Student student, Model model) {
		model.addAttribute("student", srepository.save(student));
		return "redirect:stlist";
	}

	// edit student
	@RequestMapping(value = "/editstudent/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") Long studentId, Model model) {
		model.addAttribute("student", srepository.findById(studentId));
		model.addAttribute("departments", drepository.findAll());
		return "editStudent";
	}

	// delete student
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
		srepository.deleteById(studentId);
		return "redirect:../stlist";
	}

}
package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.application.dao.StudentDAO;
import com.application.model.Student;

@Controller
public class StudentEnrollmentController {

	@Autowired
	private StudentDAO studentDao;
	
	@GetMapping("/start")
	public String start(ModelMap model) {
		return "/start";
		
		
		
	}
	
	//@RequestMapping(value="/enroll",method=RequestMethod.GET)
	@GetMapping("/enroll")
	public String newRegistration(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "enroll";
	}
	
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("/save")
	public String saveRegistration(@Valid Student student,BindingResult result,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "enroll";
		}
		
		studentDao.save(student);
		
		return "redirect:/viewstudents";
	}
	
	
	//@RequestMapping(value="/viewstudents", method=RequestMethod.GET)
	@GetMapping("/viewstudents")
	public ModelAndView getAll() {
		
		List<Student> list=studentDao.findAll();
		return new ModelAndView("viewstudents","list",list);
	}
	
	
	//@RequestMapping(value="/editstudent/{id}")
	@GetMapping("/editstudent/{id}")
	public String edit (@PathVariable int id,ModelMap model) {
		
		Student student=studentDao.findOne(id);
		model.addAttribute("student",student);
		return "editstudent";
	}
	
	
	
	//@RequestMapping(value="/editsave",method=RequestMethod.POST)
	@PostMapping("/editsave")
	public ModelAndView editsave(@ModelAttribute("student") Student p) {
		
		Student student=studentDao.findOne(p.getId());
		
		student.setFirstName(p.getFirstName());
		student.setLastName(p.getLastName());
		student.setCountry(p.getCountry());
		student.setEmail(p.getEmail());
		student.setSection(p.getSection());
		student.setSex(p.getSex());
		
		studentDao.save(student);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	//@RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
	@GetMapping("/deletestudent/{id}")
	public ModelAndView delete(@PathVariable int id) {
		Student student=studentDao.findOne(id);
		studentDao.delete(student);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	
	
	

	@ModelAttribute("sections")
	public List<String> sections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Reasearch");
		return sections;
	}
	
	
	
	@ModelAttribute("countries")
	public List<String> countries() {

		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}

	
}

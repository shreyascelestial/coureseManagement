package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentmanagement.domain.Course;
import com.example.studentmanagement.service.CourseService;


@Controller
//@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Course> listcourse = service.listAll();
		model.addAttribute("listcourse", listcourse);
		System.out.println("Get./");
		return "Course";
	}
	
	@GetMapping("/addcourse")
	public String add(Model model) {
		List<Course> listCourse = service.listAll();
		model.addAttribute("listcourse", listCourse);
		model.addAttribute("course", new Course());
		return "addcourse";
	}

	@RequestMapping(value ="/save", method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) {
		service.save(course);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCoursepage(@PathVariable(name="id") long id) {
		ModelAndView mav=new ModelAndView("addcourse");
		Course course=service.get(id);
		mav.addObject("course", course);
		return mav;		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCoursePage(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
}

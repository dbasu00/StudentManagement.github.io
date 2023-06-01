package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	StudentService ss;
	
	public String getallStudents(Model model){
		List<Student> slist=ss.getAllStudents();
		model.addAllAttributes(slist);
		return "showInfo";
	}
	@PostMapping("/register")
	public String addStudent(@RequestParam("kodId")String kodId,@RequestParam("name")String name,
			@RequestParam("branch")String branch) {
		Student s=new Student(kodId,name,branch);
		ss.addStudent(s);
		return "redirect:/";
	}
	
	@PutMapping("/updatestud")
	public String updateStudent(@RequestParam("kodId")String kodId,@RequestParam("name")String name,
			@RequestParam("branch")String branch) {
		Student st=ss.getStudent(kodId);
		st.setName(name);
		st.setBranch(branch);
		ss.updateStudent(st);
		return "redirect:/";
	}
	
	@PutMapping("/view")
	public String getStudent(@RequestParam("kodId")String kodId, Model model) {
		Student st=ss.getStudent(kodId);
		model.addAttribute("Student",st);
		
		return "showInfo";
	}
	@DeleteMapping("/remove")
	public String deleteStudent(@RequestParam("kodId")String kodId) {
		ss.deleteStudent(kodId);
		return "redirect:/";
	}
	public StudentController(StudentService ss) {
		super();
		this.ss=ss;
	}

	@GetMapping("/view")
	public String viewinfo() {
		return "viewInfo";
	}
	
	@GetMapping("/register")
	public String Register() {
		return "register";
	}
	
	@GetMapping("/update")
	public String UpdateInfo() {
		return "update";
	}
	
	@GetMapping("/remove")
	public String RemoveInfo() {
		return "remove";
	}
	
	

}

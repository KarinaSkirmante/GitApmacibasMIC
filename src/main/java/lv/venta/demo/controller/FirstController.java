package lv.venta.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.model.Student;
import lv.venta.demo.service.ICRUDStudentService;
import lv.venta.demo.service.ICRUDStudentServiceWithDB;
import lv.venta.demo.service.IFilteringService;


//@RequestParam
//@PathVariable


@Controller
//@RequestMapping("/admin/")
public class FirstController {

		
	@Autowired
	ICRUDStudentServiceWithDB studentService;
	
	@Autowired
	IFilteringService filteringService;
	
	
	@GetMapping("/test") // localhost:8080/test
	public String getFunc()
	{
		System.out.println("Check!!!");
		return "index";//will show index.html page
	}
	
	@GetMapping("/test2") //localhost:8080/test2
	public String getFunc2(Model model)
	{
		//String innerObj = "Sveiciens no JAVA backend";
		//addAttribute 1.arguments - innerObj
		//addAttribute 2.arguments - "Sveiciens no JAVA backend"
		
		model.addAttribute("innerObj", "Sveiciens no JAVA backend");
		model.addAttribute("innerObj2", "Tikai pārbaudei");
		
		return "obj-verify";//will show obj-verify.html page
	}
	
	@GetMapping("/testStudent")//localhost:8080/testStudent
	public String getTestStudent(Model model)
	{
		Student st = new Student("Janis", "Berzins");
		//allStudents.add(st);
		model.addAttribute("innerObj", st);
		return "show-student";//will show show-student.html page
	}
	
	@GetMapping("/studentList")//localhost:8080/studentList
	public String getStudentList(Model model)
	{
		model.addAttribute("innerObj", studentService.selectAll());
		return "show-all-students";//will show show-all-students.html
	}
	
	//example - RequestParam
	@GetMapping("/testStudentRequestParam")//localhost:8080/testStudentRequestParam?id=2
	public String getTestStudentRequestParam(Model model, @RequestParam(name="id") int id )
	{
		try
		{
			model.addAttribute("innerObj", studentService.selectById(id));
			return "show-student";//will show show-student.html page
		}
		catch (Exception e) {
			return "error-id";//will show error-id.html
		}
		
		
	}

	//example - PathVariable
	@GetMapping("/studentList/{id}") //localhost:8080/studentList/2
	public String getStudentById(Model model, @PathVariable(name="id") int id )
	{
		try
		{
			System.out.println(filteringService.selectGradesByStudentId(id));
			System.out.println(filteringService.selectCoursesByStudentId(id));
			
			//just for testing
			System.out.println(filteringService.selectCoursesByProfessorId(4));
			System.out.println(filteringService.calculateAVGGradeInCourseId(0));
			
			model.addAttribute("innerObj", studentService.selectById(id));
			return "show-student";//will show show-student.html page
		}
		catch (Exception e) {
			return "error-id";//will show error-id.html
		}
	}

	
	//1. phase
	
	@GetMapping("/studentAdd") //localhost:8080/studentAdd
	public String getStudentAdd(Student student)//as param -> empty Student object
	{
		return "add-student";//will show add-student.html
	}
	
	
	//2. phase
	@PostMapping("/studentAdd")
	public String postStudentAdd(@Valid Student student, BindingResult result)//as param -> Student object with all parameters stored in frontend 
	{
		if(!result.hasErrors())
		{
			if(studentService.addNew(student))
				return "redirect:/studentList";//will go to localhost:8080/studentList
			else
				return "error-param";
		}
		else
			return "add-student";
	}
	
	
	@GetMapping("/studentEdit/{id}")//localhost:8080/studentEdit/2
	public String getStudentEdit(Model model, @PathVariable(name="id") int id)
	{

		try
		{
				model.addAttribute("student", studentService.selectById(id));
				return "edit-student";//will show edit-student.html
		}
		catch (Exception e) {
			return "error-id";//
		}
		
		
	}
	
	@PostMapping("/studentEdit/{id}")
	public String postStudentEdit(@Valid Student student, BindingResult result, Model model, @PathVariable(name="id") int id)
	{
		if(!result.hasErrors())
		{
			if(studentService.editById(id, student))
				return "redirect:/studentList";//will go to localhost:8080/studentList
			else
				return "error-id";
		}
		return "edit-student";
			
	}
	
	
	@GetMapping("/studentRemove")
	public String getStudentRemove(Student student, Model model)
	{
		model.addAttribute("innerObj", studentService.selectAll());
		return "delete-student";
	}
	
	@PostMapping("/studentRemove")
	public String postStudentRemove(Student student)
	{
		if(studentService.deleteBySurname(student.getSurname()))
			return "redirect:/studentList";//will go to localhost:8080/studentList
		else
			return "error-param";
	}
	
	
	
	
}

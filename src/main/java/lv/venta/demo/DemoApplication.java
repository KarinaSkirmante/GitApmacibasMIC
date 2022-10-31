package lv.venta.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.model.Course;
import lv.venta.demo.model.Grade;
import lv.venta.demo.model.Professor;
import lv.venta.demo.model.Student;
import lv.venta.demo.repo.ICourseRepo;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.repo.IProfessorRepo;
import lv.venta.demo.repo.IStudentRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
	
	
	
	
	
	
	/*@Bean
	public CommandLineRunner addTestData(IStudentRepo studentRepo, 
			IProfessorRepo professorRepo, ICourseRepo courseRepo, 
			IGradeRepo gradeRepo)
	{
		return(args) -> {
			Student st1 = new Student("Jānis", "Bērziņš");
			Student st2 = new Student("Līga", "Foršā");
			Student st3 = new Student("Baiba", "Neforšā");
			studentRepo.save(st1);
			studentRepo.save(st2);
			studentRepo.save(st3);
			
			Professor p1 = new Professor("Karina", "Skirmante", "Mg");
			Professor p2 = new Professor("Estere", "Vītola", "Mg");
			Professor p3 = new Professor("Gaļina", "Hiļķeviča", "Dr");
			Professor p4 = new Professor("Jeļena", "Mihailovna", "Dr");
			professorRepo.save(p1);
			professorRepo.save(p2);
			professorRepo.save(p3);
			professorRepo.save(p4);
			
			ArrayList<Professor> proffForJAVA = new ArrayList<>();
			proffForJAVA.add(p1);
			
			Course c1 = new Course("Programmesana timekli JAVA", 4, proffForJAVA);
			Course c2 = new Course("Python", 4, new ArrayList<>(Arrays.asList(p2)));
			Course c3 = new Course("Matematika", 8, new ArrayList<>(Arrays.asList(p3, p4)));
			courseRepo.save(c1);
			courseRepo.save(c2);
			courseRepo.save(c3);
			
			gradeRepo.save(new Grade(10, st1, c1));
			gradeRepo.save(new Grade(5, st1, c2));
			gradeRepo.save(new Grade(3, st1, c3));
			gradeRepo.save(new Grade(6, st2, c1));
			gradeRepo.save(new Grade(2, st3, c1));
			gradeRepo.save(new Grade(5, st3, c2));
			gradeRepo.save(new Grade(7, st3, c3));
		}; 
	}*/

}

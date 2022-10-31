package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Course;
import lv.venta.demo.model.Professor;

public interface ICourseRepo extends CrudRepository<Course, Integer> {

	//SELECT * FROM CourseTable where grade consists of stduentId=?1
	ArrayList<Course> findByGradesStudentId(int id);
	//SELECT * FROM CourseTable where professor=?1
	//ArrayList<Course> findByProfessors(Professor professor);
	ArrayList<Course> findByProfessorsPid(int id);
	
	

}

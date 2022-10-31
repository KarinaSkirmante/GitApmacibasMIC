package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

	//SELECT * from GradeTable where studentId=?1
	ArrayList<Grade> findByStudentId(int id);
	
	@Query(nativeQuery=true, value="SELECT AVG(grade_value) FROM grade_table")
	float calculateAVGofALLGrades();

}

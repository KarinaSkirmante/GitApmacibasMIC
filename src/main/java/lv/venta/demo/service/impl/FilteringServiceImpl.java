package lv.venta.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Course;
import lv.venta.demo.model.Grade;
import lv.venta.demo.model.Professor;
import lv.venta.demo.repo.ICourseRepo;
import lv.venta.demo.repo.IGradeRepo;
import lv.venta.demo.service.IFilteringService;
@Service
public class FilteringServiceImpl implements IFilteringService{

	@Autowired
	IGradeRepo gradeRepo;
	
	@Autowired
	ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) {
		//get grades, if student id is known
		ArrayList<Grade> result = gradeRepo.findByStudentId(id);
		if(result!=null)
			return result;
		
		return new ArrayList<Grade>();
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) {
		ArrayList<Course> result = courseRepo.findByGradesStudentId(id);
		if(result!=null)
			return result;
	
		return new ArrayList<Course>();
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(int id) {
		ArrayList<Course> result = courseRepo.findByProfessorsPid(id);
		if(result!=null)
			return result;
		return new ArrayList<Course>();
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) {
		//only for testing
		return gradeRepo.calculateAVGofALLGrades();
	}

}

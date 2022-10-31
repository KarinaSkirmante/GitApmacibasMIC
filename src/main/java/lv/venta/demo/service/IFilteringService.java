package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.model.Course;
import lv.venta.demo.model.Grade;
import lv.venta.demo.model.Professor;

public interface IFilteringService {

	public abstract ArrayList<Grade> selectGradesByStudentId(int id);
	public abstract  ArrayList<Course> selectCoursesByStudentId(int id);
	public abstract ArrayList<Course> selectCoursesByProfessorId(int id);
	public abstract float calculateAVGGradeInCourseId(int id); 
}

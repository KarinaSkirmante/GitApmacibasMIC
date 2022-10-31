package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.model.Student;

public interface ICRUDStudentServiceWithDB {

	//select all
	public ArrayList<Student> selectAll();
	
	//select by id
	public Student selectById(int id) throws Exception ;
	
	//add new
	public boolean addNew(Student newStudent);
	
	//delete by surname
	public boolean deleteBySurname(String surname);
	
	//edit by id
	public boolean editById(int id, Student editStudent);
}

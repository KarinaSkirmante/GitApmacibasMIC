package lv.venta.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.demo.model.Student;
import lv.venta.demo.service.ICRUDStudentService;

@Service
public class CRUDStudentServiceImpl implements ICRUDStudentService {

	public ArrayList<Student> allStudents = new ArrayList<>(Arrays.asList(new Student("Līga", "Foršā"),new Student("Baiba", "Neforšā"), new Student("Pēteris", "Lielais")));

	
	@Override
	public ArrayList<Student> selectAll() {
		return allStudents;
	}

	@Override
	public Student selectById(int id) throws Exception {
		for(Student st:allStudents)
		{
			if(st.getId()==id)
			{
				return st;
			}
		}
		
		throw new Exception("Student not found");
	}

	@Override
	public boolean addNew(Student newStudent) {
		Student newSt = new Student(newStudent.getName(), newStudent.getSurname());
		for(Student st: allStudents)
		{
			if(st.getName().equals(newStudent.getName()) && st.getSurname().equals(newStudent.getSurname()))
				return false;
		}
		
		allStudents.add(newSt);
		return true;
	}

	@Override
	public boolean deleteBySurname(String surname) {
		for(Student st: allStudents)
		{
			if(st.getSurname().equals(surname))
			{
				allStudents.remove(st);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean editById(int id, Student editStudent) {
		for(Student st:allStudents)
		{
			if(st.getId()==id)
			{
				st.setName(editStudent.getName());
				st.setSurname(editStudent.getSurname());
				return true;
			}
		}
		return false;
	}

}

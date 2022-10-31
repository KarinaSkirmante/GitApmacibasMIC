package lv.venta.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.model.Student;
import lv.venta.demo.repo.IStudentRepo;
import lv.venta.demo.service.ICRUDStudentService;
import lv.venta.demo.service.ICRUDStudentServiceWithDB;

@Service
public class CRUDStudentServiceImplWithDB implements ICRUDStudentServiceWithDB {

	
	@Autowired
	IStudentRepo studentRepo;

	
	@Override
	public ArrayList<Student> selectAll() {
		return (ArrayList<Student>) studentRepo.findAll();
	}

	@Override
	public Student selectById(int id) throws Exception {
		
		Student st  = studentRepo.findById(id).get();
		
		if(st!=null)
			return st;
		
		
		throw new Exception("Student not found");
	}

	@Override
	public boolean addNew(Student newStudent) {
		
		Student st = studentRepo.findByNameAndSurname(newStudent.getName(), newStudent.getSurname());
		if(st==null)
		{
			studentRepo.save(new Student(newStudent.getName(), newStudent.getSurname()));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBySurname(String surname) {
		
		Student st = studentRepo.findBySurname(surname); 
		if(st!=null)
		{
			studentRepo.delete(st);
			return true;
		}
		
		return false;
		
	}

	@Override
	public boolean editById(int id, Student editStudent) {
		Student st  = studentRepo.findById(id).get();
		if(st!=null)
		{
			st.setName(editStudent.getName());
			st.setSurname(editStudent.getSurname());
			studentRepo.save(st);
			return true;
		}
		
		return false;
	}

}

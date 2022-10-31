package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer> {
	// SELECT * FROM StudentTable WHERE name='Karina' AND surname='Skirmante'
	Student findByNameAndSurname(String name, String surname);

	Student findBySurname(String surname);

}

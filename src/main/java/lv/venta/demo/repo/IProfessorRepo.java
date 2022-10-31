package lv.venta.demo.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor,Integer>{

}

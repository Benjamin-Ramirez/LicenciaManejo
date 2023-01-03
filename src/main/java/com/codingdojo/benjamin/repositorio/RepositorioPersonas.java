package com.codingdojo.benjamin.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.benjamin.modelos.Person;

@Repository
public interface RepositorioPersonas extends CrudRepository<Person, Long> {

	List<Person> findAll();
	List<Person> findByLicenseIdIsNull();
}

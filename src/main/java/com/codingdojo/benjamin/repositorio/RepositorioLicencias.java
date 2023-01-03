package com.codingdojo.benjamin.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.benjamin.modelos.License;

@Repository
public interface RepositorioLicencias extends CrudRepository<License, Long> {
	
	List<License> findAll();
	
	License save(License nuevaLicencia);
	
	License findByPersonId(Long id);
	

}

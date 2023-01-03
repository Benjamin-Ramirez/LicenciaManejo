package com.codingdojo.benjamin.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.benjamin.modelos.License;
import com.codingdojo.benjamin.modelos.Person;
import com.codingdojo.benjamin.repositorio.RepositorioLicencias;
import com.codingdojo.benjamin.repositorio.RepositorioPersonas;

@Service
public class Servicio {
	
	private final RepositorioPersonas repositorio_personas;
	private final RepositorioLicencias repositorio_licencias;

	public Servicio(RepositorioPersonas repositorio_personas,RepositorioLicencias repositorio_licencias) {
		this.repositorio_personas = repositorio_personas;
		this.repositorio_licencias = repositorio_licencias;
	}
	
	
	
	public List<Person> find_person(){
		return repositorio_personas.findAll();
	}
	public List<Person> persona_sin_licenica(){
		return repositorio_personas.findByLicenseIdIsNull();
	}
	
	public Person find_person_id(Long id) {
		Optional<Person> optionalPerson= repositorio_personas.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
	public Person save(Person person) {
		return repositorio_personas.save(person);
	}

	public License save_license(License newLicense) {
		
		String newNumber = ""+(count()+1);
		System.out.println(count()+1);
		newLicense.setNumber(newNumber);
		return repositorio_licencias.save(newLicense);
	}

	
	public License find_licencia_id(Long id) {
		Optional<License> optionalLicense = repositorio_licencias.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}
		else {
			return null;
		}
		
	}
	public License find_license(Long id) {
		return repositorio_licencias.findByPersonId(id);
	}
	
	public long count() {
		return repositorio_licencias.count();
	}
	

}

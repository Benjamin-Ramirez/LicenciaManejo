package com.codingdojo.benjamin.controladores;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.benjamin.modelos.License;
import com.codingdojo.benjamin.modelos.Person;
import com.codingdojo.benjamin.servicios.Servicio;

@Controller
public class AppController {
	
	@Autowired
	private Servicio servicio;
	
	
	
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("persona") Person person) {
		return "newPerson.jsp";
	}
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("licencia") License license, Model model) {
		
		List<Person> persona = servicio.persona_sin_licenica();
		model.addAttribute("persona", persona);
		return "newLicense.jsp";
	}
	@GetMapping("/persons/{id}")
	public String profile(@PathVariable("id") Long id, Model model) {
		
		Person persona = servicio.find_person_id(id);
		License licencia = servicio.find_license(id);
		model.addAttribute("persona", persona);
		model.addAttribute("licencia", licencia);
		return "details.jsp";
		
	}
	
	
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("persona") Person person, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:/persons/new";
		}
		else {
			servicio.save(person);
			return "redirect:/licenses/new";
		}
	}
	@PostMapping("/create/licence")
	public String created_license(@Valid @ModelAttribute("licencia") License license, BindingResult result, Model model) {
		
		
		if(result.hasErrors()) {
			return "newLicense.jsp";

		}
		else {
			
			servicio.save_license(license);
			return "redirect:/persons/new";
			
			
			
		}
		
	}
	
	/*
	
	 @RequestMapping(value=("/registrar"), method=RequestMethod.POST)
	public String registro(@RequestParam(value="nombre") String name,
							@RequestParam(value="email") String email,
							HttpSession session, RedirectAttributes flash) {
		

		System.out.println(name);
		System.out.println(email);
		
		if(name.equals("")) {
			flash.addFlashAttribute("errorNombre", "Porfavor introduce el nombre");
			return "redirect:/registro";
		}
		if(email.equals("")) {
			flash.addFlashAttribute("errorNombre", "Porfavor introduce el email");
			return "redirect:/registro";
		}
		session.setAttribute("nombre", name);
		return "redirect:/dashboard";
	} 
	  
	 */
	
	
	
	
	
}

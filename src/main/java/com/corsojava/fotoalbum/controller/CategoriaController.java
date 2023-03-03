package com.corsojava.fotoalbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.corsojava.fotoalbum.model.Categoria;
import com.corsojava.fotoalbum.repository.CategoriaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorie")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping()
	public String index(Model model) {
		List<Categoria> elencoCategorie;
		elencoCategorie=categoriaRepository.findAll();
		model.addAttribute("elencoCategorie", elencoCategorie);
		return "categorie/index";
	}
	
	//CREATE
	@GetMapping("/create")
	public String create(Model model) {
		Categoria categoria=new Categoria();
		model.addAttribute("categoria", categoria);
		return"categorie/create";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("categoria")Categoria formCategoria,
			BindingResult bindingResult, 
			Model model) {
		if(bindingResult.hasErrors()) {
			return"categorie/create";
		}
		categoriaRepository.save(formCategoria);
		return "redirect:/categorie";
	}
	
	
	// DELETE
		@PostMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {

			categoriaRepository.deleteById(id);
			return "redirect:/categorie";
		}

}

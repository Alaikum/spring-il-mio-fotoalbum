package com.corsojava.fotoalbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corsojava.fotoalbum.model.Commento;
import com.corsojava.fotoalbum.repository.CommentoRepository;

@Controller
@RequestMapping("/commenti")
public class CommentoController {

	
	@Autowired 
    CommentoRepository commentoRepository;
	
	@GetMapping
	public String index(Model model) {
		List<Commento> listaCommenti;
		listaCommenti=commentoRepository.findAll();
		model.addAttribute("listaCommenti", listaCommenti);
		return "commenti/index";
		
	}


}

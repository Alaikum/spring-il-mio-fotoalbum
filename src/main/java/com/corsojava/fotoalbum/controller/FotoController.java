package com.corsojava.fotoalbum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.corsojava.fotoalbum.model.Foto;
import com.corsojava.fotoalbum.repository.FotoRepository;

@Controller
@RequestMapping("/foto")
public class FotoController {

	@Autowired
	FotoRepository fotoRepository;

	@GetMapping
	public String index(Model model) {
		List<Foto> elencoFoto;
		elencoFoto = fotoRepository.findAll();
		model.addAttribute("elencoFoto", elencoFoto);

		return "foto/index";
	}
}

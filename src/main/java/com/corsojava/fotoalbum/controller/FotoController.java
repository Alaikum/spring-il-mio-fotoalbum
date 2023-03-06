package com.corsojava.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsojava.fotoalbum.model.Categoria;
import com.corsojava.fotoalbum.model.Foto;
import com.corsojava.fotoalbum.repository.CategoriaRepository;
import com.corsojava.fotoalbum.repository.FotoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/foto")
public class FotoController {

	@Autowired
	FotoRepository fotoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping
	public String index(@RequestParam(name = "titolo", required = false) String titolo,
			@RequestParam(name = "tag", required = false) String tag,
			Model model) {
		List<Foto> elencoFoto;
		if (titolo != null && !titolo.isEmpty()) {
			elencoFoto = fotoRepository.findByTitoloLike("%" + titolo + "%");
		}else if (tag != null && !tag.isEmpty()) {
			elencoFoto = fotoRepository.findByTagLike("%" + tag + "%");
		}
				else {
			elencoFoto = fotoRepository.findAll();
		}
		
		
		model.addAttribute("elencoFoto", elencoFoto);

		return "foto/index";
	}

	// SHOW
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Optional<Foto> opt = fotoRepository.findById(id);
		if (opt.isEmpty()) {
			return "redirect: foto/index";
		}
		model.addAttribute("foto", opt.get());
		return "foto/show";
	}

	// CREATE
	@GetMapping("/create")
	public String create(Model model) {
		Foto foto = new Foto();
		foto.setUrl("https://picsum.photos/1200");
		model.addAttribute("foto", foto);// foto di default

		List<Categoria> listaCategorie = categoriaRepository.findAll();
		model.addAttribute("listaCategorie", listaCategorie);
		return "foto/create";
	}

	// CREATE POST MAPPING
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("foto") Foto formFoto, BindingResult bindingResult, Model model) {
		List<Categoria> listaCategorie = categoriaRepository.findAll();
		model.addAttribute("listaCategorie", listaCategorie);
		// validazione
		if (bindingResult.hasErrors()) {
			return "/foto/create";
		}
		fotoRepository.save(formFoto);
		return "redirect:/foto";
	}

	// EDIT
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Foto foto = fotoRepository.getReferenceById(id);
		List<Categoria> listaCategorie = categoriaRepository.findAll();
		model.addAttribute("listaCategorie", listaCategorie);
		model.addAttribute("foto", foto);
		return "foto/edit";
	}

	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("foto") Foto formFoto, BindingResult bindingResult, Model model) {
		List<Categoria> listaCategorie = categoriaRepository.findAll();
		model.addAttribute("listaCategorie", listaCategorie);
		if (bindingResult.hasErrors()) {
			return "/foto/create";
		}
		fotoRepository.save(formFoto);
		return "redirect:/foto";
	}

	// DELETE
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		fotoRepository.deleteById(id);
		return "redirect:/foto";
	}

}

package com.corsojava.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsojava.fotoalbum.model.Commento;
import com.corsojava.fotoalbum.model.Foto;
import com.corsojava.fotoalbum.repository.CommentoRepository;
import com.corsojava.fotoalbum.repository.FotoRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/foto")
public class FotoRestController {
	
	@Autowired
	FotoRepository fotoRepository;
	
	@Autowired
	CommentoRepository commentoRepository;
	
	//INDEX
	@GetMapping()
	public List<Foto> index(){
		return fotoRepository.findAll();
	}
	//SHOW
	@GetMapping("{id}")
	public ResponseEntity<Foto> show(@PathVariable("id") Long id){
		Optional<Foto> result=fotoRepository.findById(id);
		if(result.isPresent()) {
			return new ResponseEntity<Foto>(result.get(),HttpStatus.OK);
			}
		else {
			return new ResponseEntity<Foto>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//CREA COMMENTI
	@PostMapping("/{id}/commenti")
	public ResponseEntity<String> addComment(@Valid @PathVariable("id") Long id, @RequestBody Commento commento) {
		Optional<Foto> result = fotoRepository.findById(id);
		if (result.isPresent()) {
			Foto foto = result.get();
			commento.setFoto(foto);
			commentoRepository.save(commento);
			return ResponseEntity.ok("Commento aggiunto con succetto");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

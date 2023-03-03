package com.corsojava.fotoalbum.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Commento {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	private String nome;
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	
	@ManyToOne
	@JsonBackReference
	private Foto foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	
}

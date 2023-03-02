package com.corsojava.fotoalbum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Foto {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	private String titolo;
	
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	private String url;
	
	
	@Size(min = 3, message = "Devono essere almeno 3 caratteri")
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	private String tag;
	
	
	
	@NotEmpty(message = "Attenzione!Campo Vuoto!")
	@NotNull(message = "Attenzione!Campo nullo!")
	private Boolean visibile;
	
	
	
	

}

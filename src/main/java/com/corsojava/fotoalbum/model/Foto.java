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


	
	//SETTER GETTER

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}



	public Boolean getVisibile() {
		return visibile;
	}



	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}
	
	
	
	
	
	
	
	

}

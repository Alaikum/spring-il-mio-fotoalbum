package com.corsojava.fotoalbum.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	
	
	
	@NotNull(message = "Attenzione!Campo nullo!")
	private Boolean visibile;
	
	
	@OneToMany(mappedBy = "foto", cascade=CascadeType.ALL)
	private List<Commento> commenti;
	
	@ManyToMany
	private List<Categoria> categorie;


	
	//SETTER GETTER
	

	public Long getId() {
		return id;
	}



	public List<Commento> getCommenti() {
		return commenti;
	}



	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}



	public List<Categoria> getCategorie() {
		return categorie;
	}



	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
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

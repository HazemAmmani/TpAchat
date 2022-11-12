package com.esprit.examen.dto;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.Produit;

@Getter
@Setter
public class DtoCategorieProduit {
	
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	private Set<Produit> produits;
	
	public DtoCategorieProduit(String codeCategorie, String libelleCategorie) {
		super();
		this.codeCategorie = codeCategorie;
		this.libelleCategorie = libelleCategorie;
	}
	
	

}

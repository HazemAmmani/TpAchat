package com.esprit.examen.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.SecteurActivite;

@Getter
@Setter
public class DtoFournisseur {
	
	private Long idFournisseur;
	private String code;
	private String libelle;
	private CategorieFournisseur  categorieFournisseur;
	private Set<Facture> factures;
    private Set<SecteurActivite> secteurActivites;
    private DetailFournisseur detailFournisseur;
	public DtoFournisseur(String code, String libelle, CategorieFournisseur categorieFournisseur) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.categorieFournisseur = categorieFournisseur;
	}
    
    
    

}

package com.esprit.examen.dto;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Stock;

@Getter
@Setter
public class DtoProduit {
	
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	private Date dateCreation;
	private Date dateDerniereModification;
	private Stock stock;
	private Set<DetailFacture> detailFacture;
	private CategorieProduit categorieProduit;
	
	public DtoProduit(String codeProduit, String libelleProduit, float prix, Date dateCreation,
			Date dateDerniereModification) {
		super();
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prix = prix;
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
	}
	
	
	

}

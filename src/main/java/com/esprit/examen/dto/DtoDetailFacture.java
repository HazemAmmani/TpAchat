package com.esprit.examen.dto;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Produit;

@Getter
@Setter
public class DtoDetailFacture {
	private Long idDetailFacture;
	private Integer qteCommandee;
	private float prixTotalDetail;
	private Integer pourcentageRemise;
	private float montantRemise;
	private Produit produit;
	Facture facture;
	
	public DtoDetailFacture(Integer qteCommandee, float prixTotalDetail, Integer pourcentageRemise,
			float montantRemise) {
		super();
		this.qteCommandee = qteCommandee;
		this.prixTotalDetail = prixTotalDetail;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}
	
	

}

package com.esprit.examen.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.Fournisseur;
@Getter
@Setter
public class DtoSecteurActivite {
	
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	private Set<Fournisseur> fournisseurs;
	
	public DtoSecteurActivite(String codeSecteurActivite, String libelleSecteurActivite) {
		super();
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	
	
	
	
	


}

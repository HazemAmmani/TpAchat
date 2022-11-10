package com.esprit.examen.dto;
import java.util.Date;
import com.esprit.examen.entities.Facture;
import lombok.Data;


@Data
public class ReglementDTO{

	private Long idReglement;
	private float montantPaye;
	private float montantRestant;
	private Boolean payee;
	private Date dateReglement;
	private Facture facture;
}

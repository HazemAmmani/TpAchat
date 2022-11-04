package com.esprit.examen.services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)
public class ReglementServiceImplTest {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Reglement reglement1=new Reglement((long)1, 21F, 10F, null, null, null);
	private Reglement reglement2=new Reglement((long)2, 21F, 10F, null, null, null);
	@MockBean
	private ReglementRepository reglementrepository;
	@Autowired
	IReglementService reglementService;
	
	@Test
	public void addReglement() throws ParseException {
		Date dateReglement = dateFormat.parse("30/09/2000");
		reglement1.setDateReglement(dateReglement);
		//
		when(reglementrepository.save(reglement1)).thenReturn(reglement1);
		assertNotNull(reglement1);

		Reglement persisted = reglementService.addReglement(reglement1);
		assertEquals(reglement1, persisted);

		System.out.println("AddReglement works !");
	}
	@Test
	public void retrieveReglement(){
		when(reglementrepository.findById(reglement1.getIdReglement())).thenReturn(Optional.of(reglement1));
		assertEquals(reglement1, reglementService.retrieveReglement(reglement1.getIdReglement()));
		System.out.println("retrieveReglement works !");
	}
	
	@Test
	public void retrieveAllReglements() {
		when(reglementrepository.findAll()).thenReturn(Stream.of(reglement1, reglement2).collect(Collectors.toList()));
		assertEquals(2, reglementService.retrieveAllReglements().size());
		System.out.println("retrieveAllReglements works !");
	}
	/*
	@Test
	public void retrieveReglementByFacture() {
		when(reglementrepository.retrieveReglementByFacture(reglement1.getIdReglement())).thenReturn(null);
		assertEquals(reglement1, reglementService.retrieveReglement(reglement1.getIdReglement()));
		System.out.println("retrieveReglementByFacture works !");
	}*/
	/*
	@Test
	public void getChiffreAffaireEntreDeuxDate() throws ParseException {
		Date date1 = dateFormat.parse("30/08/2000");
		Date date2 = dateFormat.parse("30/10/2000");
		when(reglementrepository.getChiffreAffaireEntreDeuxDate(date1, date2)).thenReturn();
		System.out.println("getChiffreAffaireEntreDeuxDate works !");
		
	}
	*/
	
}

package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
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
import com.esprit.examen.repositories.FactureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)
public class FactureServiceImplTest {

	@MockBean
	private FactureRepository factureRepository;
	private Facture facture1 = new Facture(1L, 15F, 100F, new Date(), new Date(), true, null, null, null);
	private Facture facture2 = new Facture(2L, 5F, 50F, new Date(), new Date(), true, null, null, null);

	@Autowired
	IFactureService factureService;

	@Test
	public void addFactureTest() {
		when(factureRepository.save(facture1)).thenReturn(facture1);
		assertNotNull(facture1);

		Facture persisted = factureService.addFacture(facture1);
		assertEquals(facture1, persisted);

		System.out.println("AddFacture works !");
	}

	@Test
	public void retrieveAllFacturesTest() {
		when(factureRepository.findAll()).thenReturn(Stream.of(facture1, facture2).collect(Collectors.toList()));

		assertEquals(2, factureService.retrieveAllFactures().size());
		System.out.println("RetrieveAllFactures works !");
	}

	
	@Test
	public void retrieveFactureTest() {
		when(factureRepository.findById(facture1.getIdFacture())).thenReturn(Optional.of(facture1));
		assertEquals(facture1, factureService.retrieveFacture(facture1.getIdFacture()));
		System.out.println("RetrieveFacture works !");
	}

	
}

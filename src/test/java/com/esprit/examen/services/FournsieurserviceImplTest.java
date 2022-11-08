package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)



public class FournsieurserviceImplTest {
	
	@MockBean
	private FournisseurRepository FournisseurRepository;
	private Fournisseur Fournisseur1 = new Fournisseur(1L,"test" ,"test2",null,null,null,null);
	private Fournisseur Fournisseur2 = new Fournisseur(2L,"testt" ,"testtt2",null,null,null,null);
	
	@Autowired
	IFournisseurService FourniseurService;
	
	@Test
	public void addFournisseurTest() {
    	when(FournisseurRepository.save(Fournisseur1)).thenReturn(Fournisseur1);
    	assertNotNull(Fournisseur1);
    	
    	Fournisseur persisted = FourniseurService.addFournisseur(Fournisseur1);
		assertEquals(Fournisseur1, persisted); 
    	
		System.out.println("add Fournisseur works !");
	}
	
	 @Test 
	    public void retrieveAllFournisseurTest() {
	    	when(FournisseurRepository.findAll()).thenReturn(Stream
	    			.of(Fournisseur1,Fournisseur2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,FourniseurService.retrieveAllFournisseurs().size());
	    	System.out.println("Retrieve all Fournisseur works !");
	    }
	 
	 /*@Test 
	    public void UpdateFournisseurTest() {
	    	when(FournisseurRepository.save(Fournisseur1)).thenReturn(Fournisseur1);
	    	assertNotNull(Fournisseur1);
	    	assertEquals(Fournisseur1, FourniseurService.updateFournisseur(Fournisseur1));
	    	System.out.println("Update operators works!");
	    }*/

	 @Test
	    public void retrieveFournisseurTest() {
	    	when(FournisseurRepository.findById(Fournisseur1.getIdFournisseur())).thenReturn(Optional.of(Fournisseur1));
	    	assertEquals(Fournisseur1, FourniseurService.retrieveFournisseur(Fournisseur1.getIdFournisseur()));
	    	System.out.println("Retrieve operator by id works !");
	    }
}
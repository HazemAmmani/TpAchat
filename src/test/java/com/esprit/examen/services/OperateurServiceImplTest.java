package com.esprit.examen.services;
//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = Produit.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class ProduitServiceImplTest {
	@Mock
	OperateurRepository operateurRepository;

	@InjectMocks
	OperateurServiceImpl operateurServiceService;



	List<Operateur> list = new ArrayList<Operateur>() {

		{
			add(new Operateur());
			add(new Operateur());

		}
	};

	@Test
	void  getAllOperaeurTest()
	{
		List<Operateur> Operqteurlist = new ArrayList<Operateur>() {

			{

				add (new Operateur(1L,"test1","tes1","5425",null));
				add (new Operateur(1L,"test11","tes12","56125",null));
				add (new Operateur(1L,"test12","tes11","56125",null));

			}};

		assertTrue(Operqteurlist.size()>0);
		Mockito.when(operateurServiceService.retrieveAllOperateurs()).thenReturn(Operqteurlist);
		List<Operateur> factureList = operateurServiceService.retrieveAllOperateurs();
	}



	@Test
	void test_addOperateur() {
		Operateur p= new Operateur();
		p.setIdOperateur(1L);
		//mock
		Mockito.when(operateurRepository.save(any())).thenReturn(p);

		//assert
		assertEquals(1L, p.getIdOperateur());
	}

	public void delete() {

		Operateur p = operateurRepository.findById(1L).get();
		operateurRepository.delete(p);
		operateurServiceService.deleteOperateur(null);

	}



}
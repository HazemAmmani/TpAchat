package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;


@ComponentScan
@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//@ExtendWith(MockitoExtension.class)
//@DataJdbcTest

//@DataJpaTest
//@AutoConfigureDataJpa
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@TestComponent
@JdbcTest
public class OperateurServiceImplTest {
	
	@Mock
	private OperateurRepository operateurRepository;
	
	@Autowired
	IOperateurService operateurService;
	
//	 Operateur operateur1 = new Operateur(1L,"test1","tes1","546125",null);
//	 Operateur operateur2 = new Operateur(2L,"test2","test2","546125",null);
	
	@Test
	
	public void retrieveAllOperateursTest() {
    	when(operateurRepository.findAll()).thenReturn(Stream
    			.of(new Operateur(1L,"test1","tes1","546125",null),new Operateur(2L,"test2","test2","546125",null))
    			.collect(Collectors.toList())); 
    	assertEquals(2, operateurService.retrieveAllOperateurs());}
//	  @Test
//	  @Order(1)
//		public void addOperateurTest() {
//	    	when(operateurRepository.save(operateur1)).thenReturn(operateur1);
//	    	assertNotNull(operateur1);
//	    	
//    	Operateur persisted = operateurService.addOperateur(operateur1);
//			assertEquals(operateur1, persisted); 
//	    	
//			System.out.println("add operators works !");
//	}
//	
// @Test 
// @Order(2)
//	   public void retrieveAllOperateursTest() {
//	    	when(operateurRepository.findAll()).thenReturn(Stream
//	    			.of(operateur1,operateur2)
//	    			.collect(Collectors.toList()));
//	    	
//	    	assertEquals(2,operateurService.retrieveAllOperateurs().size());
//   	System.out.println("Retrieve all operators works !");
//    }
//	
//	   @Test 
//	   @Order(3)
//	    public void UpdateOperateurTest() {
//	    	when(operateurRepository.save(operateur1)).thenReturn(operateur1);
//	    	assertNotNull(operateur1);
//	    	assertEquals(operateur1, operateurService.updateOperateur(operateur1));
//	    	System.out.println("Update operators works!");
//	    }
//	    
//	    @Test
//	    @Order(4)
//	    public void retrieveOperateurTest() {
//	    	when(operateurRepository.findById(operateur1.getIdOperateur())).thenReturn(Optional.of(operateur1));
//	    	assertEquals(operateur1, operateurService.retrieveOperateur(operateur1.getIdOperateur()));
//	    	System.out.println("Retrieve operator by id works !");
//	    }
//	

}

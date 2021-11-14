package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService es;
	
	@Test
	@Order(1)
	public void testRetrieveAllEntreprises() {
		List<Entreprise> Entreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals(0,Entreprises.size());
	}
	
	@Test
	@Order(2)
	public void testAddEntreprise() {
		Entreprise u = es.addEntreprise(new Entreprise());
		Assertions.assertNotNull(u);
	}
	
	@Test
	@Order(3)
	public void testRetrieveEntreprise() {
		Entreprise u = es.retrieveEntreprise("1");
		Assertions.assertNotNull(u);
	}
	
	
	@Test 
	@Order(4)
	public void testUpadteEntreprise() {
		Entreprise u = es.retrieveEntreprise("1");
		Entreprise updatedEntreprise = es.updateEntreprise(u);
		Assertions.assertNotNull(updatedEntreprise);
	}
	
	
	@Test
	@Order(5)
	public void testDeleteEntreprise() {
		es.deleteEntreprise("1");
		Entreprise entreprise = null;
		try{
			entreprise = es.retrieveEntreprise("1");
		}catch(Exception e) {
			
		}
		Assertions.assertNull(entreprise);
	}

}
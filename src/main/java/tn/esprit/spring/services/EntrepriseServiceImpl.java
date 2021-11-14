package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService{
	
	@Autowired
	EntrepriseRepository entrepriseRepository;

	
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	
	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null; 
		try {
	
			logger.info("Dans retrieveAllEntreprises");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise entreprise: entreprises) {
				logger.info("Entreprise :"+entreprise);
			} 
			logger.info("Finished retrieveAllEntreprises");
		}catch (Exception e) {
			logger.error("error executing retrieveAllEntreprises: "+e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		
				logger.info("Entered addEntreprise(e)");
				Entreprise e_saved = entrepriseRepository.save(e); 
				logger.info("addEntreprise finished");
				return e_saved; 
		
	}

	@Override
	public void deleteEntreprise(String id) {
		
				logger.info("Entered deleteEntreprise(id)");
				entrepriseRepository.deleteById(Integer.parseInt(id)); 
				// TODO Log à ajouter à la fin de la méthode 
				logger.info("Finished deleteEntreprise(id)");
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		// TODO Log à ajouter en début de la méthode 
				logger.info("Entered updateEntreprise(e)");
				Entreprise e_saved = entrepriseRepository.save(e); 
				// TODO Log à ajouter à la fin de la méthode 
				logger.info("Finished updateEntreprise(e)");
				return e_saved; 
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		// TODO Log à ajouter en début de la méthode 
				logger.info("Entered retrieveEntreprise(id)");
				Entreprise e =  entrepriseRepository.findById(Integer.parseInt(id)).get(); 
				// TODO Log à ajouter à la fin de la méthode 
				logger.info("Finished retrieveEntreprise(id)");
				return e; 
	}

}
package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
    
	// TODO Logger à ajouter  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	//hahahah
			// TODO LLog à ajouter en début de la méthode 
			l.info("In retrieve Method");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   
				l.info("User : " + user.getLastName());
			} 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("Out retrieve Method");

		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			l.error("Something went wrong");
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		return u; 
	}

}
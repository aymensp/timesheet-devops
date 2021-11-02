package tn.esprit.spring.services;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.User;

@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	IUserService us;
	
	@Test 
	public void testRetrieveAllUsers(){
		List<User> listUsers = us.retrieveAllUsers();
		
		Assertions.assertEquals(1,listUsers.size() );
	}
	
}

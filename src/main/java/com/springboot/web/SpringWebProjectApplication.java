package com.springboot.web;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.web.entities.User;
import com.springboot.web.repositiory.UserRepo;

@SpringBootApplication
public class SpringWebProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringWebProjectApplication.class, args);
		UserRepo userrepositiory = context.getBean(UserRepo.class);
		/*
		 * User user = new User(); user.setName("parul"); user.setCity("Noida");
		 * user.setStatus("okay");
		 * 
		 * User User1 = userrepositiory.save(user); System.out.println(User1);
		 */

		/*
		 * User user1 = new User(); user1.setName("pari"); user1.setCity("Meerut");
		 * user1.setStatus("not okay");
		 * 
		 * User user2 = new User(); user2.setName("panjari"); user2.setCity("jatser");
		 * user2.setStatus("False");
		 * 
		 * List u = List.of( user1, user2); Iterable<User> result =
		 * userrepositiory.saveAll(u); result.forEach(use -> { System.out.println(use);
		 * });
		 */

		// update the user
		/*
		 * Optional<User > optional =userrepositiory.findById(6); User user =
		 * optional.get(); user.setCity("Mumbai"); User result =
		 * userrepositiory.save(user); System.out.println(result);
		 */

		// get all data

		/*
		 * Iterable<User> itr =userrepositiory.findAll();
		 * 
		 * Iterator<User> iterator = itr.iterator(); while(iterator.hasNext()) { User
		 * user = iterator.next(); System.out.println(user); }
		 * 
		 * 
		 * itr.forEach(user ->{ System.out.println(user); });
		 */
		
		// deleting the user 
		
		/* userrepositiory.deleteById(5); */
		
		//custom defined methods 
		/*
		 * List<User> user = userrepositiory.findByName("Avika");
		 * user.forEach(e->System.out.println(e));
		 * 
		 * List<User> use =userrepositiory.findByCity("Noida");
		 * use.forEach(e->System.out.println(e));
		 */
		
		/*
		 * List<User> alluser =userrepositiory.getAllUser(); alluser.forEach(e->
		 * System.out.println(e));
		 * 
		 * 
		 * List<User> allByname = userrepositiory.getUserByName("Parul");
		 * allByname.forEach(e->System.out.println(e));
		 * 
		 * System.out.println("********************************************");
		 * 
		 * userrepositiory.getUser().forEach(e->System.out.println(e));
		 * 
		 */	}

}

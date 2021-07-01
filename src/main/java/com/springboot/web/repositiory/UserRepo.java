package com.springboot.web.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.web.entities.User;
@Repository 
public interface UserRepo extends CrudRepository<User, Integer>  {
	
	public List<User> findByName(String name);
	public List<User> findByCity(String city);
	
	@Query("select u FROM User u")
	public List<User> getAllUser();
	
	@Query("select u FROM User u WHERE u.name=:n")
	public List<User> getUserByName(@Param("n") String name);
	
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getUser();

	
}

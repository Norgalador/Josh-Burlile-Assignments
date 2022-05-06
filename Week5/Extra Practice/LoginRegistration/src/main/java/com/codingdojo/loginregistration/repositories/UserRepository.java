package com.codingdojo.loginregistration.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginregistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
 User findByEmail(String email);
 
}
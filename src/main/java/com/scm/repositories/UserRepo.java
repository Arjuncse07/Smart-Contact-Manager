package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.arjun.scm20.entities.User;


public interface UserRepo extends JpaRepository<User,String> {

}

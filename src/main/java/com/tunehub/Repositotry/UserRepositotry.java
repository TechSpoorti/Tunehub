package com.tunehub.Repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.Entity.Users;

public interface UserRepositotry extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email);

}

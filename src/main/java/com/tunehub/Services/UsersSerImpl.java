package com.tunehub.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunehub.Entity.Users;
import com.tunehub.Repositotry.UserRepositotry;

@Service
public class UsersSerImpl implements UserService {
	@Autowired
	UserRepositotry repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user added susscessfully";
	}

	@Override
	public boolean exitsEmail(String email) {
		if(repo.findByEmail(email)==null) {
		return false;
	}else {
		return true;
	}

}

	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}else {
		
		return false;
	}}

	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}
}
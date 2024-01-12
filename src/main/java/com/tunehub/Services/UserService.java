package com.tunehub.Services;



import com.tunehub.Entity.Users;

public interface UserService {
 public String addUser(Users user);

public boolean exitsEmail(String email);

public boolean validateUser(String email, String password);

public String getRole(String email);
public  Users getUser(String email);
public void updateUser(Users user);

}

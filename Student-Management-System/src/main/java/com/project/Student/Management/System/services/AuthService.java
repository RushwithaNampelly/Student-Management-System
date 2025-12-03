package com.project.Student.Management.System.services;

import com.project.Student.Management.System.models.User;
import com.project.Student.Management.System.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    //register
    public User register(User user){
        User existing = userRepository.findByEmail(user.getEmail());
if(existing!=null){
    throw new RuntimeException("Email ALREADY EXISTS");
}
return userRepository.save(user);


    }

    //login
    public boolean login(String email,String password){
        User user = userRepository.findByEmail(email);
        if(user==null) return false;
      return user.getPassword().equals(password);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);

    }
}

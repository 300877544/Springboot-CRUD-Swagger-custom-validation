package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return  userRepository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserById(int id){return userRepository.findById(id).orElse(null);}

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return  "User removed " + id;
    }
    public User updateUser(User user)
    {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Users.")
public class CustomController {
    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }

    @Autowired
    private UserService service;
    @PostMapping("/user")
    @ApiOperation("Creates a new User")
    public User addUser(@ApiParam("User information for a new user to be created.")@RequestBody User user){return service.saveUser(user);}
    @PostMapping("/users")
    @ApiOperation("Creates more than one Users")
    public List<User> addUsers(@ApiParam("More than one user to be created")@RequestBody List<User> users){
        return service.saveUsers(users);
    }
    @GetMapping("/users")
    @ApiOperation("Returns list of all Users in the system.")
    public  List<User> findAllUsers(){return service.getUsers();}
    @GetMapping("/user/{id}")
    @ApiOperation("Returns a specific user by their identifier")
    public User findUserById(@PathVariable int id){ return  service.getUserById(id);}
    @PutMapping("/user")
    @ApiOperation("Updates a user")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    @ApiOperation("Deletes a person from the system based on the identifier.")
    public String deleteUser(@ApiParam("Id of the person to be deleted.")@PathVariable int id) {
        return service.deleteUser(id);
    }


}

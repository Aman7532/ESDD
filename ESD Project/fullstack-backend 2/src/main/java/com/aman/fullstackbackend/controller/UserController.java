package com.aman.fullstackbackend.controller;


import com.aman.fullstackbackend.exception.UserNotFoundException;
import com.aman.fullstackbackend.model.User;
import com.aman.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:3000")

public class UserController {

         @Autowired
         private UserRepository userRepository;


         @PostMapping("/user")
          User newUser(@RequestBody User newUser)

         {   User savedUser = userRepository.save(newUser);

             // Get the ID of the newly saved user
             Long newUserId = savedUser.getId();

             // Concatenate the ID to the branch and update the user entity
             savedUser.setBranch(savedUser.getBranch() + newUserId.toString());

             // Save the updated user entity with the modified branch
             return userRepository.save(savedUser);

         }
         @GetMapping("/users")
         List<User>getAllUsers(){
             return userRepository.findAll();

         }
         @GetMapping("/user/{id}")
         User getUserById(@PathVariable Long id){
             return userRepository.findById(id)
                     .orElseThrow(()->new UserNotFoundException(id));
         }
         @PutMapping("/user/{id}")
         User updateUser(@RequestBody User newUser,@PathVariable Long id)
         {
             return userRepository.findById(id)
                     .map(user -> {
                         user.setUsername(newUser.getUsername());
                         user.setName(newUser.getName());
                         user.setPhotograph_path(newUser.getPhotograph_path());
                         user.setEmail(newUser.getEmail());
                         user.setCgpa(newUser.getCgpa());

                         return userRepository.save(user);
                     }).orElseThrow(()->new UserNotFoundException(id));

         }
         @DeleteMapping("/user/{id}")
        String deleteUser (@PathVariable Long id){
             if(!userRepository.existsById(id)){
                 throw new UserNotFoundException(id);
             }
             userRepository.deleteById(id);
             return "user with id "+id+"has been deleted success .";
         }


}

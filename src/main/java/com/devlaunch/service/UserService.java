package com.devlaunch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlaunch.entity.User;
import java.util.List;
import com.devlaunch.repository.UserRepository;
import com.devlaunch.exception.ResourceNotFoundException;
import com.devlaunch.exception.EmailAlreadyExistsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());

            return userRepository.save(existingUser);
        }

        return null;
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User getUserByName(String name) {

        User user = userRepository.findByName(name);

        if (user == null) {
            throw new ResourceNotFoundException("User not found with name: " + name);
        }

        return user;
    }

}
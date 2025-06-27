package om.healthmate.javaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import om.healthmate.javaproject.entity.User;
import om.healthmate.javaproject.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public java.util.List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
} 
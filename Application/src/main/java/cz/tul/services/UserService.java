package cz.tul.services;

import cz.tul.data.User;
import cz.tul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }

    public boolean exists(User user) {
        return userRepository.exists(user.getId_user());
    }

    public boolean exists(int userId) {
        return userRepository.exists(userId);
    }

    public User get(User user){
        return userRepository.findOne(user.getId_user());
    }

    public User get(int userId){
        return userRepository.findOne(userId);
    }

    public List<User> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(User user){
        userRepository.delete(user.getId_user());
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}

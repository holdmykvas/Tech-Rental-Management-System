package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import pj.techrentalsystem.DTOs.UserDto;
import pj.techrentalsystem.Entities.User;
import pj.techrentalsystem.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        //TODO
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with this id { " + id + " } is not found!"));
    }
}

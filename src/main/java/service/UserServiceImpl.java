package service;

import entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll(Sort.by("id"));
    }

    @Override
    public User addUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isEmpty()) {
            return null;
        }
        return userRepository.save(User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build());

    }

    @Override
    public User deleteUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
        return null;
    }
        userRepository.deleteById(userId);
    return optionalUser.get();
    }

    @Override
    public User updateUser(Long userId, User user) {
        User user1 = userRepository.findById(userId).orElse(null);
        user1.setId(userId);
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return user1;
    }
}

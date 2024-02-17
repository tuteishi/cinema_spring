package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.UserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.entities.User;
import by.cinema.cinema_web.exceptions.UserNotFoundException;
import by.cinema.cinema_web.mappers.UserMapper;
import by.cinema.cinema_web.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        userRepository.save(user);
        return userMapper.mapUserToUserResponse(user);
    }


    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new UserNotFoundException(userId.toString()));
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.mapUserListToUserResponseList(allUsers);
    }

    @Override
    @Transactional
    public UserResponse updateUser(UserRequest userRequest, Long userId) {
        User user = userMapper.mapUserRequestToUser(userRequest);
        user.setUserId(userId);
        userRepository.save(user);
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateApiUserRequest;
import by.cinema.cinema_web.dto.requests.CreateUserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.dto.responses.api.Root;
import by.cinema.cinema_web.entities.User;
import by.cinema.cinema_web.exceptions.UserNotFoundException;
import by.cinema.cinema_web.feingClients.ReqresClient;
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
    private final ReqresClient reqresClient;

    @Override
    @Transactional
    public UserResponse createUser(CreateUserRequest userRequest) {
        User user = userMapper.userRequestToUser(userRequest);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse createApiUser(CreateApiUserRequest createApiUserRequest) {
        User user = userMapper.userApiRequestToUser(createApiUserRequest);
        Root apiUser = reqresClient.getApiUser();
        String firstName = apiUser.getData().getFirst_name();
        String surname = apiUser.getData().getLast_name();
        user.setFirstname(firstName);
        user.setSurname(surname);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new UserNotFoundException(userId.toString()));
        return userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.userListToUserResponseList(allUsers);
    }

    @Override
    @Transactional
    public UserResponse updateUser(CreateUserRequest userRequest, Long userId) {
        User user = userMapper.userRequestToUser(userRequest);
        user.setUserId(userId);
        userRepository.save(user);
        return userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
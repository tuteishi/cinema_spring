package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.CreateApiUserRequest;
import by.cinema.cinema_web.dto.requests.CreateUserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest userRequest);

    UserResponse createApiUser(CreateApiUserRequest createApiUserRequest);

    UserResponse getUserById(Long userId);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(CreateUserRequest userRequest, Long UserId);

    void deleteUser(Long userId);
}
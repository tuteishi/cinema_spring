package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.UserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(Long userId);

    List<UserResponse> getUsers();

    UserResponse updateUser(UserRequest userRequest, Long UserId);

    void deleteUser(Long userId);
}
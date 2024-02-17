package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.UserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;

import java.util.List;

public interface UserService {

    /** Create user. */
    UserResponse createUser(UserRequest userRequest);

    /** Getting a user by id. */
    UserResponse getUserById(Long userId);

    /** Getting all users. */
    List<UserResponse> getUsers();

    /** Update user. */
    UserResponse updateUser(UserRequest userRequest, Long UserId);

    /** Delete user. */
    void deleteUser(Long userId);
}
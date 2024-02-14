package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.CreateApiUserRequest;
import by.cinema.cinema_web.dto.requests.CreateUserRequest;
import by.cinema.cinema_web.dto.responses.UserResponse;
import by.cinema.cinema_web.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid CreateUserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping("apiUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createApiUser(@RequestBody @Valid CreateApiUserRequest createApiUserRequest) {
        return userService.createApiUser(createApiUserRequest);
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("allUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@RequestBody @Valid CreateUserRequest userRequest,
                                   @PathVariable Long id) {
        return userService.updateUser(userRequest, id);
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
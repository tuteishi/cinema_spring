package by.cinema.cinema_web.dto.responses;

import by.cinema.cinema_web.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long userId;

    private String firstname;

    private String surname;

    private Integer age;

    private UserRole userRole;
}
package by.cinema.cinema_web.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static by.cinema.cinema_web.entities.UserRole.USER;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_ROLE", nullable = false)
    @Enumerated(STRING)
    private UserRole userRole = USER;
}
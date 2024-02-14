package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

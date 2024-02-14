package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
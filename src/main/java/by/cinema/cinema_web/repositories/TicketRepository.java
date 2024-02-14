package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.entities.Ticket;
import by.cinema.cinema_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long>, TicketRepositoryCustom {
    @Query(value = "SELECT * FROM TICKETS WHERE FILM_ID = :filmId AND SAIL = 0", nativeQuery = true)
    List <Ticket> getFreeTicketsByFilmId (Long filmId);
    @Query(value = "SELECT * FROM TICKETS WHERE USER_ID = :userId", nativeQuery = true)
    List<Ticket> getUserTickets (Long userId);
}
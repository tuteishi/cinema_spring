package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long>, TicketRepositoryCustom {

    List<Ticket> findAllByUser_UserId(Long userId);
}
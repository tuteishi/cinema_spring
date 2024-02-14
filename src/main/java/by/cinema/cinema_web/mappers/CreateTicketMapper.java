package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.entities.Ticket;
import org.springframework.stereotype.Component;

@Component
public class CreateTicketMapper {
    public Ticket CreateNewTicket(Film film, Integer count) {
        return Ticket.builder()
                .film(film)
                .numberOfSeat(count)
                .coast(15)
                .build();
    }
}
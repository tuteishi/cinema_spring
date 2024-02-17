package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.entities.Ticket;
import org.springframework.stereotype.Component;

import static by.cinema.cinema_web.utils.Constants.TICKET_COAST;

@Component
public class CreateTicketMapper {
    public Ticket createNewTicket(Film film, Integer numberOfSeat) {
        return Ticket.builder()
                .film(film)
                .numberOfSeat(numberOfSeat)
                .coast(TICKET_COAST)
                .isSail(false)
                .build();
    }
}
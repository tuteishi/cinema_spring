package by.cinema.cinema_web.dto.responses;

import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private Long ticketId;

    private User user;

    private Film film;

    private Integer numberOfSeat;

    private BigDecimal coast;

    private boolean isSail;
}
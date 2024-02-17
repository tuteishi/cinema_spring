package by.cinema.cinema_web.mappers;

import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Ticket;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketResponse mapTicketToTicketResponse(Ticket ticket);

    List<TicketResponse> mapTicketListToTicketResponseList(List<Ticket> tickets);

}
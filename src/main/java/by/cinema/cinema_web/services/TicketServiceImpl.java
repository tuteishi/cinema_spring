package by.cinema.cinema_web.services;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.entities.Film;
import by.cinema.cinema_web.entities.Ticket;
import by.cinema.cinema_web.exceptions.TicketNotFoundException;
import by.cinema.cinema_web.mappers.CreateTicketMapper;
import by.cinema.cinema_web.mappers.TicketMapper;
import by.cinema.cinema_web.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CreateTicketMapper createTicketMapper;
    private final TicketMapper ticketMapper;

    @Override
    @Transactional
    public void createTickets(Film film) {
        List<Ticket> tickets = new ArrayList<>();
        IntStream.range(1, 10)
                .forEach(numberOfSeat -> tickets.add(createTicketMapper.createNewTicket(film, numberOfSeat)));
        ticketRepository.saveAll(tickets);
    }

    @Override
    @Transactional(readOnly = true)
    public TicketResponse getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).
                orElseThrow(() -> new TicketNotFoundException(ticketId.toString()));
        return ticketMapper.mapTicketToTicketResponse(ticket);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketResponse> getTickets() {
        List<Ticket> allTickets = ticketRepository.findAll();
        return ticketMapper.mapTicketListToTicketResponseList(allTickets);
    }

    @Override
    @Transactional
    public List<TicketResponse> getFreeTickets(Long filmId) {
        List<Ticket> freeTickets = ticketRepository.getFreeTickets(filmId);
        return ticketMapper.mapTicketListToTicketResponseList(freeTickets);
    }

    @Override
    @Transactional
    public List<TicketResponse> getUserTickets(Long userId) {
        List<Ticket> userTickets = ticketRepository.findAllByUser_UserId(userId);
        return ticketMapper.mapTicketListToTicketResponseList(userTickets);
    }

    @Override
    @Transactional
    public SailTicketResponse buyTicket(TicketRequest ticketRequest, Long userId) {
        ticketRepository.buyTicket(ticketRequest, userId);
        return SailTicketResponse.builder().
                ticketId(ticketRequest.getTicketId())
                .isSail(true)
                .build();
    }

    @Override
    @Transactional
    public SailTicketResponse returnTicket(TicketRequest ticketRequest) {
        ticketRepository.returnTicket(ticketRequest);
        return SailTicketResponse.builder().
                ticketId(ticketRequest.getTicketId())
                .isSail(false)
                .build();
    }
}
package by.cinema.cinema_web.controllers;

import by.cinema.cinema_web.dto.requests.TicketRequest;
import by.cinema.cinema_web.dto.responses.SailTicketResponse;
import by.cinema.cinema_web.dto.responses.TicketResponse;
import by.cinema.cinema_web.services.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("ticket/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public SailTicketResponse buyTicket(@PathVariable @NotNull Long userId,
                                        @RequestBody @Valid TicketRequest ticketRequest) {
        return ticketService.buyTicket(ticketRequest, userId);
    }

    @PostMapping("ticket")
    @ResponseStatus(HttpStatus.OK)
    public SailTicketResponse returnTicket(@RequestBody @Valid TicketRequest ticketRequest) {
        return ticketService.returnTicket(ticketRequest);
    }

    @GetMapping("ticket/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponse getTicketById(@PathVariable @NotNull Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("free-tickets/{filmId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getFreeTickets(@PathVariable @NotNull Long filmId) {
        return ticketService.getFreeTickets(filmId);
    }

    @GetMapping("user-tickets/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getUserTickets(@PathVariable @NotNull Long userId) {
        return ticketService.getUserTickets(userId);
    }

    @GetMapping("tickets")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> getAllTickets() {
        return ticketService.getTickets();
    }
}
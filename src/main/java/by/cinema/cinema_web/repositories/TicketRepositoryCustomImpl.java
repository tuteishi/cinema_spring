package by.cinema.cinema_web.repositories;

import by.cinema.cinema_web.dto.requests.CreateTicketRequest;
import by.cinema.cinema_web.entities.Ticket;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import static by.cinema.cinema_web.entities.QTicket.ticket;

public class TicketRepositoryCustomImpl extends QuerydslRepositorySupport
        implements TicketRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public TicketRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Ticket.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional
    public Long buyTicket(CreateTicketRequest ticketRequest, Long userId) {
        return jpaQueryFactory.update(ticket)
                .where(ticket.ticketId.eq(ticketRequest.getTicketId()))
                .set(ticket.sail, true)
                .set(ticket.user.userId, userId)
                .execute();
    }

    @Override
    @Transactional
    public Long returnTicket(CreateTicketRequest ticketRequest) {
        return jpaQueryFactory.update(ticket)
                .where(ticket.ticketId.eq(ticketRequest.getTicketId()))
                .set(ticket.sail, false)
                .set(ticket.user.userId, (Long) null)
                .execute();
    }
}
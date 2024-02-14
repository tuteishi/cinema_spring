package by.cinema.cinema_web.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "public", name = "TICKETS")
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticketId;
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "FILM_ID", nullable = false)
    private Film film;
    @Column(name = "NUMBER_OF_SEAT", nullable = false)
    private Integer numberOfSeat;
    @Column(name = "COAST", nullable = false)
    private Integer coast;
    @Column(name = "SAIL")
    private boolean sail;
}
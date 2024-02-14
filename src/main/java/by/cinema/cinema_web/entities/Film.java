package by.cinema.cinema_web.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema ="public", name = "FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FILM_ID")
    private Long filmId;
    @Column(name = "FILM_NAME", nullable = false)
    private String filmName;
    @Column(name = "SHOW_DATE_TIME", nullable = false)
    private LocalDateTime showDataTime;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film", orphanRemoval = true)
//    List<Ticket> tickets;
}
package org.cinema.ticket.infrastructure;

import org.cinema.common.Seat;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Convert(converter = SeatConverter.class)
    Seat seat;
    Long movieId;
    BigDecimal price;
    double discount;

    public TicketEntity(){
    }

    public TicketEntity(Long id, Seat seat, Long movieId, BigDecimal price, double discount) {
        this.id = id;
        this.seat = seat;
        this.movieId = movieId;
        this.price = price;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public Seat getSeat() {
        return seat;
    }

    public Long getMovieId() {
        return movieId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}

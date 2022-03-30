package org.cinema.movie.infrastructure;

import org.cinema.common.Seat;
import org.cinema.common.Seats;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Long id;
    String name;
    String description;
    LocalDateTime date;
    BigDecimal ticketPrice;
    @Convert(converter = SeatListConverter.class)
    Seats occupiedSeats;
    Long length;

    public MovieEntity(){
    }

    public MovieEntity(Long id, String name, String description, LocalDateTime date, BigDecimal ticketPrice, List<Seat> occupiedSeats, Long length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.occupiedSeats = new Seats(occupiedSeats);
        this.length = length;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setOccupiedSeats(Seats occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public Seats getOccupiedSeats() {
        return occupiedSeats;
    }

    public Long getLength() {
        return length;
    }
}

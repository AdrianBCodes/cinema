package org.cinema.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.cinema.common.Seat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Movie {
    private Long id;
    private final String name;
    private final String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime date;
    private final BigDecimal ticketPrice;
    private final List<Seat> occupiedSeats;
    private final Long length;

    Movie(Long id, String name, String description, LocalDateTime date, BigDecimal ticketPrice, List<Seat> occupiedSeats, Long length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.occupiedSeats = occupiedSeats;
        this.length = length;
    }

    Movie(String name, String description, LocalDateTime date, BigDecimal ticketPrice, List<Seat> occupiedSeats, Long length) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.occupiedSeats = occupiedSeats;
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

    public List<Seat> getOccupiedSeats() {
        return occupiedSeats;
    }

    public Long getLength() {
        return length;
    }

    Movie copyMovieWithNewDate(LocalDateTime dateTime) {
        return new Movie(name, description, dateTime, ticketPrice, occupiedSeats, length);
    }

    Movie assignSeatToMovie(Seat seat) {
        var updatedOccupiedSeats = Stream.concat(this.getOccupiedSeats().stream(), Stream.of(seat))
                .collect(Collectors.toList());
        return new Movie(this.id, name, description, date, ticketPrice, updatedOccupiedSeats, length);
    }
}

package org.cinema.ticket;

import org.cinema.common.Seat;

import java.math.BigDecimal;

public class Ticket {
    private Long id;
    private final Seat seat;
    private final Long movieId;
    private final BigDecimal price;
    private final double discount;

    public Ticket(Seat seat, Long movieId, BigDecimal price) {
        this.seat = seat;
        this.movieId = movieId;
        this.price = price;
        this.discount = 0.0;
    }

    public Ticket(Long id, Seat seat, Long movieId, BigDecimal price, double discount) {
        this.id = id;
        this.seat = seat;
        this.movieId = movieId;
        this.price = price;
        this.discount = discount;
    }

    public Ticket(Seat seat, Long movieId, BigDecimal price, double discount) {
        validateDiscount(discount);
        this.seat = seat;
        this.movieId = movieId;
        this.price = price.multiply(BigDecimal.valueOf(1.0 - discount));
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

    void validateDiscount(double discount) {
        if (discount < 0.0 || discount >= 1.0) {
            throw new RuntimeException("Wrong discount");
        }
    }
}

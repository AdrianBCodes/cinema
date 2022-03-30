package org.cinema.movie;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MovieBuilder {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private BigDecimal ticketPrice;
    private Long length;

    public static MovieBuilder builder(){
        return new MovieBuilder();
    }

    public MovieBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public MovieBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public MovieBuilder withDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public MovieBuilder withTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
        return this;
    }

    public MovieBuilder withLength(Long length) {
        this.length = length;
        return this;
    }

    public Movie build(){
        return new Movie(name, description, date, ticketPrice, List.of(), length);
    }

}

package org.cinema.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovieWriteModel {
    private String name;
    private String description;
    private LocalDateTime date;
    private BigDecimal ticketPrice;
    private Long length;

    public MovieWriteModel(){
    }

    public MovieWriteModel(String name, String description, LocalDateTime date, BigDecimal ticketPrice, Long length) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}

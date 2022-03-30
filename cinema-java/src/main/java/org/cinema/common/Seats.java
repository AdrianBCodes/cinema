package org.cinema.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seats {
    public List<Seat> seats = new ArrayList<>();

    public Seats() {
    }

    public Seats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seats seats1 = (Seats) o;
        return Objects.equals(seats, seats1.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seats);
    }
}

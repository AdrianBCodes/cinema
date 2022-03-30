package org.cinema.movie;

import org.cinema.common.Seat;
import org.cinema.movie.Movie;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieExample {
    public static Movie movie1WithNoSeats = new Movie(1L, "Film1", "desc1", LocalDateTime.MIN, BigDecimal.valueOf(5L), List.of(), 120L);
    public static Movie movie2With16Seats = new Movie(2L, "Film2", "desc2", LocalDateTime.MIN, BigDecimal.valueOf(5L), seatsGenerator(16), 120L);

    public static Movie movieWith1Seat(Seat seat) {
        return new Movie(1L, "Film1", "desc1", LocalDateTime.MIN, BigDecimal.valueOf(5L), List.of(seat), 120L);
    }

    private static List<Seat> seatsGenerator(int number) {
        List<Seat> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            result.add(new Seat("A", i));
        }
        return result;
    }
}
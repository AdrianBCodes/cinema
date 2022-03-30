package org.cinema.movie.infrastructure;

import org.cinema.common.Seat;
import org.cinema.common.Seats;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class SeatListConverter implements AttributeConverter<Seats, String> {

    static String DELIMITER = ",";
    @Override
    public String convertToDatabaseColumn(Seats seats) {
        if (seats == null || seats.seats == null || seats.seats.isEmpty()) {
            return "";
        }
        return seats.seats.stream().map(Seat::toString).collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Seats convertToEntityAttribute(String stringOfSeats) {
        if (stringOfSeats == null || stringOfSeats.trim().length() == 0) {
            return new Seats();
        }
        return new Seats(Arrays.stream(stringOfSeats.split(DELIMITER)).map(Seat::fromString).collect(Collectors.toList()));
    }
}

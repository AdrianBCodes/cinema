package org.cinema.ticket.infrastructure;

import org.cinema.common.Seat;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SeatConverter implements AttributeConverter<Seat, String> {

    @Override
    public String convertToDatabaseColumn(Seat seat) {
        if (seat == null) {
            return "";
        }
        return seat.toString();
    }

    @Override
    public Seat convertToEntityAttribute(String stringOfSeat) {
        if (stringOfSeat == null || stringOfSeat.trim().length() == 0) {
            return null;
        }
        return Seat.fromString(stringOfSeat);
    }
}

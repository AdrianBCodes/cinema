package org.cinema.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;


public class Seat implements Serializable {
    public String row;
    public int number;

    @JsonCreator
    public Seat(@JsonProperty(value = "row") String row, @JsonProperty(value = "number") int number) {
//        assert row != null;
        this.row = row;
        this.number = number;
    }

    public static Seat fromString(String string){
        return new Seat(string.substring(0,1), Integer.parseInt(string.substring(1)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return number == seat.number && Objects.equals(row, seat.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, number);
    }

    @Override
    public String toString() {
        return row + number;
    }

}

package org.cinema.seat;

import org.assertj.core.api.BDDAssertions;
import org.cinema.common.Seat;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.*;

public class SeatTest {

    @Test
    public void seatToString(){
        // given
        Seat seat = new Seat("A", 1);
        Seat seat2 = new Seat("A", 10);
        // when
        var result = seat.toString();
        var result2 = seat2.toString();
        // then
        assertThat(result).isEqualTo("A1");
        assertThat(result2).isEqualTo("A10");
    }

    @Test
    public void seatFromString(){
        // given
        String seat = "A1";
        // when
        var result = Seat.fromString(seat);
        // then
        assertThat(result).isEqualTo(new Seat("A", 1));
    }

}

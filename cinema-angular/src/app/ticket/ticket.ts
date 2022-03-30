import Big from "big.js";
import { Seat } from "../seat";

export class Ticket {
    id: number;
    seat: Seat;
    movieId: number;
    price: Big;
    discount: number;
}

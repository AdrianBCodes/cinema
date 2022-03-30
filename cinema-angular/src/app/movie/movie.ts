import Big from 'big.js'
import { Seat } from '../seat';

export class Movie {
    id: number;
    name: string;
    description: string;
    date: Date;
    ticketPrice: Big;
    occupiedSeats: Seat[];
    length: number;
}

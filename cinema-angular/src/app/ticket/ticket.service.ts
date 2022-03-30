import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from './ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  
  private baseURL = "http://localhost:8080/api/v1/tickets"

  constructor(private httpClient : HttpClient) { }

  getTicketsList(): Observable<Ticket[]>{
    return this.httpClient.get<Ticket[]>(this.baseURL);
  }

  getTicketById(id: number): Observable<Ticket>{
    return this.httpClient.get<Ticket>(this.baseURL + '/' + id);
  }

  addTicket(ticket: Ticket): Observable<Object>{
    return this.httpClient.post<Object>(this.baseURL, ticket);
  }

  editTicket(id: number, movie: Ticket): Observable<Object>{
    return this.httpClient.put<Object>(this.baseURL + '/' + id, movie);
  }

  deleteTicket(id: number): Observable<Object>{
    return this.httpClient.delete(this.baseURL + '/' + id);
  }
}

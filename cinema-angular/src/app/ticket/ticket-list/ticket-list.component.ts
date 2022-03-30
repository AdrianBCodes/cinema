import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/movie/movie.service';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  public tickets: Ticket[];
  movieService: MovieService;
  namesMap = new Map();

  constructor(private ticketService: TicketService,
    movieService: MovieService,
    private router: Router) {
      this.movieService = movieService;
  }

  ngOnInit(): void {
    this.getTickets();
    this.getMovieNamesFromIds();
  }

  private getTickets(){
      this.ticketService.getTicketsList().subscribe(data => {
        this.tickets = data;
        console.log(data);
      })
  }

  goToAddTicket(){
    this.router.navigate(['add-ticket']);
  }

  editTicket(id:number){
    this.router.navigate(['edit-ticket', id]);
  }

  deleteTicket(id:number){
    this.ticketService.deleteTicket(id).subscribe(data => {
      console.log(data);
      this.getTickets();
    });
  }

  ticketDetails(id:number){
    this.router.navigate(['ticket-details', id]);
  }

  getMovieNamesFromIds(){
    this.movieService.getMoviesList().subscribe(movies => movies.forEach(movie => this.namesMap.set(movie.id, movie.name)));
  }

}

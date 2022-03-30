import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/movie/movie';
import { MovieService } from 'src/app/movie/movie.service';
import { Ticket } from '../ticket';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-add-ticket',
  templateUrl: './add-ticket.component.html',
  styleUrls: ['./add-ticket.component.css']
})
export class AddTicketComponent implements OnInit {

  ticket: Ticket = new Ticket();

  constructor(private ticketService: TicketService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveTicket(){
    this.ticketService.addTicket(this.ticket).subscribe(data => {
      console.log(data);
      this.goToTicketList();
    })
  }

  goToTicketList(){
    this.router.navigate(['/tickets']);
  }

  onSubmit(){
    console.log(this.ticket);
    this.saveTicket();
  }
}

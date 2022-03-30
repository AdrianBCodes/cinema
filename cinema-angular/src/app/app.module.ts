import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { AddMovieComponent } from './movie/add-movie/add-movie.component';
import { EditMovieComponent } from './movie/edit-movie/edit-movie.component';
import { MovieDetailsComponent } from './movie/movie-details/movie-details.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TicketListComponent } from './ticket/ticket-list/ticket-list.component';
import { AddTicketComponent } from './ticket/add-ticket/add-ticket.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    AddMovieComponent,
    EditMovieComponent,
    MovieDetailsComponent,
    HomePageComponent,
    TicketListComponent,
    AddTicketComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

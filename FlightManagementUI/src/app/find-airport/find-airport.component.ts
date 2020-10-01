import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportServiceService } from '../services/airport-service.service';

@Component({
  selector: 'app-find-airport',
  templateUrl: './find-airport.component.html',
  styleUrls: ['./find-airport.component.css']
})
export class FindAirportComponent implements OnInit {
  airport : Airport = null;
  searchAirportCode : string;
  show : boolean = false;
  errorShow : boolean = false;
  private airportService : AirportServiceService;
  constructor(airportService : AirportServiceService, private router : Router) { 
    this.airportService=airportService;
  }

  ngOnInit(): void {
  }

  getAirport(){
    let response : Observable<Airport> = this.airportService.getAirport(this.searchAirportCode);
    response.subscribe((airport : Airport) =>{
      this.airport=airport;
      this.show = true;
      this.errorShow = false;
    },
      error =>{
        alert(error);
        this.errorShow = true;
        this.show = false;
        console.log("Error "+error);
      }
    );
    
  }
  deleteAirport(){
    let response : Observable<Airport> = this.airportService.deleteAirport(this.airport.airportCode);
    response.subscribe((resp : Airport) =>{
      alert(resp.airportCode+" Deleted Successfully!");
    },
    error =>{
      console.log("Error "+error);
      alert(error);
    });
    this.show = false;
    this.errorShow = false;
    this.ngOnInit();
  }

  updateAirport(airportCode : string){
    this.router.navigate(['/updateAirport',airportCode]);
  }

}

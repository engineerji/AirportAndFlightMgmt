import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportModel } from '../model/airportModel';
import { AirportServiceService } from '../services/airport-service.service';

@Component({
  selector: 'app-add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent implements OnInit {

  airportModel : AirportModel = new AirportModel("","","");
  airportResponse : Airport = null;
  show : boolean = false;
  constructor(private airportService : AirportServiceService, private router : Router) { }

  ngOnInit(): void {
  }

  addAirport(){
    let response : Observable<Airport> = this.airportService.addAirport(this.airportModel);
    response.subscribe((airportResponse : Airport) =>{
      this.airportResponse = airportResponse;
      alert(this.airportResponse.airportCode + " Added Successfully!");
    },
    error =>{
      console.log("Error "+error);
      alert(error);
    });
    this.airportModel = new AirportModel("","","");
    this.show = true;
    this.router.navigate(['']);
  }
}

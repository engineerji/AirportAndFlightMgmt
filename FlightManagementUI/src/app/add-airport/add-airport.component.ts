import { Component, OnInit } from '@angular/core';
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
  airportService : AirportServiceService;
  airportResponse : Airport = null;
  show : boolean = false;
  constructor(airportService : AirportServiceService) {
    this.airportService = airportService;
   }

  ngOnInit(): void {
  }

  addAirport(){
    let response : Observable<Airport> = this.airportService.addAirport(this.airportModel);
    response.subscribe((airportResponse : Airport) =>{
      this.airportResponse = airportResponse;
    },
    error =>{
      console.log("Error "+error);
      alert(error);
    });
    this.airportModel = new AirportModel("","","");
    this.show = true;
  }
}

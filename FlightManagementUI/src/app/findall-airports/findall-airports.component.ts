import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportServiceService } from '../services/airport-service.service';

@Component({
  selector: 'app-findall-airports',
  templateUrl: './findall-airports.component.html',
  styleUrls: ['./findall-airports.component.css']
})
export class FindallAirportsComponent implements OnInit {

  airports : Airport[] = null;
  private airportService : AirportServiceService;
  constructor(airportService : AirportServiceService, private router : Router) { 
    this.airportService=airportService;
  }

  ngOnInit(): void {
    let response : Observable<Airport[]> = this.airportService.getAllAirports();
    response.subscribe((airports : Airport[]) =>{
      this.airports=airports;
    },
      error =>{
        alert(error);
        console.log("Error "+error);
      }
    );
  }
  deleteAirport(airportCode : string){
    let response : Observable<Airport> = this.airportService.deleteAirport(airportCode);
    response.subscribe((resp : Airport) =>{
    alert(resp.airportCode + " Deleted Successfully!");
    },
    error =>{
      console.error("Error "+error);
      alert(error);
    });
    this.ngOnInit();
  }
  updateAirport(airportCode : string){
    this.router.navigate(['/updateAirport',airportCode]);
  }

}

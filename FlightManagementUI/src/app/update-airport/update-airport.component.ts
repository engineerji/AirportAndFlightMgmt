import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportServiceService } from '../services/airport-service.service';

@Component({
  selector: 'app-update-airport',
  templateUrl: './update-airport.component.html',
  styleUrls: ['./update-airport.component.css']
})
export class UpdateAirportComponent implements OnInit {

  airport : Airport;
  airportCode : string;
  constructor(private airportService: AirportServiceService, private route : ActivatedRoute,private router : Router) { }

  ngOnInit(): void {
    this.airportCode = this.route.snapshot.paramMap.get("airportCode");
    let response : Observable<Airport> = this.airportService.getAirport(this.airportCode);
    response.subscribe((airport : Airport) =>{
      this.airport=airport;
    },
      error =>{
        console.log("Error "+error);
        alert(error);
      }
    );
  }

  updateAirport(){
    let response : Observable<Airport> = this.airportService.updateAirport(this.airport);
    response.subscribe((resp : Airport) =>{
      alert(resp.airportCode +" Updated Successfully!");
    },
      error =>{
        console.log("Error "+error);
        alert(error);
      }
    );
    this.router.navigate(['']);
  }
}

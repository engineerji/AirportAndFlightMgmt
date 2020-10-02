import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { Schedule } from '../model/schedule';
import { AirportServiceService } from '../services/airport-service.service';
import { ScheduleserviceService } from '../services/scheduleservice.service';

@Component({
  selector: 'app-update-schedule',
  templateUrl: './update-schedule.component.html',
  styleUrls: ['./update-schedule.component.css']
})
export class UpdateScheduleComponent implements OnInit {

  schedule : Schedule;
  airportList : Airport[];
  hasError : boolean = false;
  dateError : boolean = false;
  constructor(private scheduleService : ScheduleserviceService, 
    private airportService : AirportServiceService,
    private route : ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    let scheduleId = this.route.snapshot.paramMap.get("scheduleId");
    let response : Observable<Schedule> = this.scheduleService.getSchedule(scheduleId);
    response.subscribe((schedule : Schedule) =>{
      this.schedule = schedule;
      
    },
    error =>{
      console.log("Error "+error);
    });
    let resp : Observable<Airport[]> = this.airportService.getAllAirports();
    resp.subscribe((airportList : Airport[]) =>{
      this.airportList = airportList;
    },
    error =>{
      console.log("Error "+error);
    });
  }

  updateSchedule(){
    let a1 = this.findAirport(this.schedule.sourceAirport.airportCode);
    let a2 = this.findAirport(this.schedule.destinationAirport.airportCode);
    let updatedSchedule = new Schedule(this.schedule.scheduleId,a1,a2,this.schedule.arrivalTime,this.schedule.departureTime);
    let response : Observable<Schedule> = this.scheduleService.updateSchedule(updatedSchedule);
    response.subscribe((resp : Schedule) =>{    
      alert(resp.scheduleId+" Updated Successfully!");
    },
    error =>{
      console.log("Error "+error);
      alert(error);
    });
    this.router.navigate(['']);
  }

  findAirport(code : string):Airport{
    for(let airport of this.airportList){
      if(airport.airportCode == code){
        return airport;
      }
    }
  }

  validateAirport(a1 : string, a2 : string){
    if(a1 == a2){
      this.hasError = true;
    }
    else{
      this.hasError = false;
    }
  }
  validateDate(arrivalTime : Date, departureTime : Date){
    if(departureTime <= arrivalTime){
      this.dateError = true;
    }
    else{
      this.dateError = false;
    }
  }

}

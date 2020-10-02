import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Airport } from '../model/airport';
import { AirportModel } from '../model/airportModel';
import { Schedule } from '../model/schedule';
import { ScheduleModel } from '../model/scheduleModel';
import { AirportServiceService } from '../services/airport-service.service';
import { ScheduleserviceService } from '../services/scheduleservice.service';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {

  scheduleModel : ScheduleModel = new ScheduleModel("",new Airport("","",""),new Airport("","",""),null,null);
  scheduleResponse : Schedule = null;
  show : boolean = false;
  airportList : Airport[] = null;
  hasError : boolean = false;
  dateError : boolean = false;
  todayDate : Date;
  constructor(private scheduleService : ScheduleserviceService, private airportService : AirportServiceService,
    private router : Router) { }

  ngOnInit(): void {
    let resp : Observable<Airport[]> = this.airportService.getAllAirports();
    resp.subscribe((airportList : Airport[]) =>{
      this.airportList = airportList;
    },
    error =>{
      alert(error);
      console.log("Error "+error);
    });
    this.todayDate = new Date();
  }

  addSchedule(){
    let a1 = this.findAirport(this.scheduleModel.sourceAirport.airportCode);
    let a2 = this.findAirport(this.scheduleModel.destinationAirport.airportCode);
    let schedule = new Schedule(this.scheduleModel.scheduleId,a1,a2,this.scheduleModel.arrivalTime,this.scheduleModel.departureTime);
    let response : Observable<Schedule> = this.scheduleService.addSchedule(schedule);
    response.subscribe((scheduleResponse : Schedule) =>{
      this.scheduleResponse = scheduleResponse;
      alert("Successfully Added!");
    },
    error =>{
      alert(error);
      console.log("Error "+error);
    });
    this.scheduleModel = new ScheduleModel("",new Airport("","",""),new Airport("","",""),null,null);
    this.show = true;
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
    this.todayDate = new Date();
    if(departureTime <= arrivalTime || this.todayDate>= arrivalTime){
      this.dateError = true;
    }
    else{
      this.dateError = false;
    }
  }
}

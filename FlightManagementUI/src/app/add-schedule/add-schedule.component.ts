import { Component, OnInit } from '@angular/core';
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

  scheduleModel : ScheduleModel = new ScheduleModel("",null,null,null,null);
  scheduleResponse : Schedule = null;
  show : boolean = false;
  airportList : Airport[] = null;
  msg : string =null;
  hasError : boolean = false;
  dateError : boolean = false;
  todayDate : Date;
  scheduleService : ScheduleserviceService;
  airportService : AirportServiceService;
  constructor(scheduleService : ScheduleserviceService, airportService : AirportServiceService) {
    this.scheduleService = scheduleService;
    this.airportService = airportService;
   }

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

  addSchedule(scheduleForm : any){
    let scheduleDetails = scheduleForm.value;
    let code1 = scheduleDetails.sourceAirport;
    let code2 = scheduleDetails.destinationAirport;
    let a1 = this.findAirport(code1);
    let a2 = this.findAirport(code2);
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
    this.scheduleModel = new ScheduleModel("",null,null,null,null);
    this.show = true;
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

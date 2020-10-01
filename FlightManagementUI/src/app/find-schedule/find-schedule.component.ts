import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Schedule } from '../model/schedule';
import { ScheduleserviceService } from '../services/scheduleservice.service';

@Component({
  selector: 'app-find-schedule',
  templateUrl: './find-schedule.component.html',
  styleUrls: ['./find-schedule.component.css']
})
export class FindScheduleComponent implements OnInit {

  schedule : Schedule = null;
  searchScheduleId : string;
  show : boolean = false;
  errorShow : boolean = false;
  constructor(private scheduleService : ScheduleserviceService,private router : Router) {  }

  ngOnInit(): void {
  }

  getSchedule(){
    let response : Observable<Schedule> = this.scheduleService.getSchedule(this.searchScheduleId);
    response.subscribe((schedule : Schedule) =>{
      this.schedule = schedule;
      this.show = true;
      this.errorShow = false;
      
    },
    error =>{
      this.show = false;
      this.errorShow = true;
      console.log("Error "+error);
      alert(error);
    });
  }

  deleteSchedule(){
    let response : Observable<Schedule> = this.scheduleService.deleteSchedule(this.schedule.scheduleId);
    response.subscribe((resp : Schedule) =>{
     alert(resp.scheduleId+" Deleted Successfully!");
    },
    error =>{
      alert(error);
      console.error("Error "+error);
    });
    this.show = false;
    this.errorShow = false;
    this.ngOnInit();
  }

  updateSchedule(scheduleId : string){
    this.router.navigate(['/updateSchedule',scheduleId]);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, scheduled } from 'rxjs';
import { Schedule } from '../model/schedule';
import { ScheduleserviceService } from '../services/scheduleservice.service';

@Component({
  selector: 'app-findall-schedules',
  templateUrl: './findall-schedules.component.html',
  styleUrls: ['./findall-schedules.component.css']
})
export class FindallSchedulesComponent implements OnInit {

  schedules : Schedule[] = null;
  constructor(private scheduleService : ScheduleserviceService, private router : Router) {   }

  ngOnInit(): void {
    let response : Observable<Schedule[]> = this.scheduleService.getAllSchedules();
    response.subscribe((schedules : Schedule[]) =>{
      this.schedules=schedules;
    },
      error =>{
        alert(error);
        console.log("Error "+error);
      }
    );
  }

  deleteSchedule(scheduleId : string){
    let response : Observable<Schedule> = this.scheduleService.deleteSchedule(scheduleId);
    response.subscribe((resp : Schedule) =>{
      alert(resp.scheduleId+" Deleted Successfully!");
    
    },
    error =>{
      console.error("Error "+error);
      alert(error);
    });
    this.ngOnInit();
  }

  updateSchedule(scheduleId : string){
    this.router.navigate(['/updateSchedule',scheduleId]);
  }

}

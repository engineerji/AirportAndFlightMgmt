import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Schedule } from '../model/schedule';

@Injectable({
  providedIn: 'root'
})
export class ScheduleserviceService {

  client : HttpClient;
  baseScheduleUrl = "http://localhost:8087/schedules";

  constructor(client : HttpClient) {
    this.client = client;
   }

  addSchedule(schedule : Schedule):Observable<Schedule>{
    let url = this.baseScheduleUrl+"/add";
    return this.client.post<Schedule>(url,schedule).pipe(catchError(this.errorHandler));
  }

  getSchedule(scheduleId : string):Observable<Schedule>{
   let url = this.baseScheduleUrl+"/getSchedule/"+scheduleId;
   return this.client.get<Schedule>(url).pipe(catchError(this.errorHandler));
 }

 updateSchedule(schedule : Schedule):Observable<Schedule>{
   let url = this.baseScheduleUrl+"/updateSchedule/"+schedule.scheduleId;
   return this.client.put<Schedule>(url,schedule).pipe(catchError(this.errorHandler));
 }

 getAllSchedules():Observable<Schedule[]>{
   let observable : Observable<Schedule[]> = this.client.get<Schedule[]>(this.baseScheduleUrl).pipe(catchError(this.errorHandler));
   return observable;
 }

 deleteSchedule(scheduleId : string):Observable<Schedule>{
   let url = this.baseScheduleUrl+"/delete/"+scheduleId;
   return this.client.delete<Schedule>(url).pipe(catchError(this.errorHandler));
   
 }

 errorHandler(error : HttpErrorResponse){
  return throwError(error.error.message || "Server Error");
}
}

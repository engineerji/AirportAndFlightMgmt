import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Airport } from '../model/airport';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AirportServiceService {

  client : HttpClient;
  baseAirportUrl = "http://localhost:8087/airports";

  constructor(client : HttpClient) {
    this.client = client;
   }

   addAirport(airport : Airport):Observable<Airport>{
     let url = this.baseAirportUrl+"/add";
     return this.client.post<Airport>(url,airport).pipe(catchError(this.errorHandler));
   }

   getAirport(airportCode : string):Observable<Airport>{
    let url = this.baseAirportUrl+"/getAirport/"+airportCode;
    let observable : Observable<Airport> = this.client.get<Airport>(url).pipe(catchError(this.errorHandler));
    return observable;
  }

  updateAirport(airport : Airport):Observable<Airport>{
    let url = this.baseAirportUrl+"/updateAirport/"+airport.airportCode;
    let observable : Observable<Airport> = this.client.put<Airport>(url,airport).pipe(catchError(this.errorHandler));
    return observable;
  }

  getAllAirports():Observable<Airport[]>{
    return this.client.get<Airport[]>(this.baseAirportUrl).pipe(catchError(this.errorHandler));
  }

  deleteAirport(airportCode : string):Observable<Airport>{
    let url = this.baseAirportUrl+"/delete/"+airportCode;
    return this.client.delete<Airport>(url).pipe(catchError(this.errorHandler));
  }

  errorHandler(error : HttpErrorResponse){
    return throwError(error.error.message || "Server Error");
  }
}

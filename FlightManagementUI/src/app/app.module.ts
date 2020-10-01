import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AirportServiceService } from './services/airport-service.service';
import { ScheduleserviceService } from './services/scheduleservice.service';
import { FindAirportComponent } from './find-airport/find-airport.component';
import { FindScheduleComponent } from './find-schedule/find-schedule.component';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { FindallSchedulesComponent } from './findall-schedules/findall-schedules.component';
import { FindallAirportsComponent } from './findall-airports/findall-airports.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { UpdateScheduleComponent } from './update-schedule/update-schedule.component';
import { HomeComponentComponent } from './home-component/home-component.component';

@NgModule({
  declarations: [
    AppComponent,
    FindAirportComponent,
    FindScheduleComponent,
    AddScheduleComponent,
    AddAirportComponent,
    FindallSchedulesComponent,
    FindallAirportsComponent,
    UpdateAirportComponent,
    UpdateScheduleComponent,
    HomeComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AirportServiceService, ScheduleserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

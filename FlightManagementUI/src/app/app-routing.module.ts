import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { AppComponent } from './app.component';
import { FindAirportComponent } from './find-airport/find-airport.component';
import { FindScheduleComponent } from './find-schedule/find-schedule.component';
import { FindallAirportsComponent } from './findall-airports/findall-airports.component';
import { FindallSchedulesComponent } from './findall-schedules/findall-schedules.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { UpdateScheduleComponent } from './update-schedule/update-schedule.component';



const routes: Routes = [
  {path:'addAirport',component:AddAirportComponent},
  {path:'addSchedule',component:AddScheduleComponent},
  {path:'findAirport',component:FindAirportComponent},
  {path:'findSchedule',component:FindScheduleComponent},
  {path:'findAllAirports', component:FindallAirportsComponent},
  {path:'findAllSchedules', component:FindallSchedulesComponent},
  {path: 'updateAirport/:airportCode', component:UpdateAirportComponent},
  {path: 'updateSchedule/:scheduleId', component:UpdateScheduleComponent},
  {path:'',component:HomeComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

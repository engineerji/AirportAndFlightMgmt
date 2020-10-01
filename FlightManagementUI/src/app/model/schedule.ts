import { Airport } from "./airport";

export class Schedule{
    scheduleId : string;
    sourceAirport : Airport;
    destinationAirport : Airport;
    arrivalTime : Date;
    departureTime : Date;

    constructor(scheduleId : string, sourceAirport : Airport, destinationAirport : Airport, arrivalTime : Date, departureTime : Date){
        this.scheduleId=scheduleId;
        this.sourceAirport=sourceAirport;
        this.destinationAirport=destinationAirport;
        this.arrivalTime=arrivalTime;
        this.departureTime=departureTime;
    }
}
export class AirportModel{
    airportCode : string;
    airportName : string;
    airportLocation : string;
    
    constructor(airportCode : string, airportName : string, airportLocation : string){
        this.airportCode=airportCode;
        this.airportName=airportName;
        this.airportLocation=airportLocation;
    }
}
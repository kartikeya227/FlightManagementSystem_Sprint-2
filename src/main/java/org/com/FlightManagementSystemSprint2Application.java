package org.com;

import org.com.model.airport;
import org.com.model.schedule;
import org.com.model.scheduledFlight;
import org.com.services.ScheduledFlightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlightManagementSystemSprint2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(FlightManagementSystemSprint2Application.class, args);


//		ScheduledFlightService service = ctx.getBean(ScheduledFlightService.class);
//	    schedule schedule=new schedule();
//	    scheduledFlight scheduleFlight=new scheduledFlight();
//	    airport airport=new airport();
//	    scheduleFlight.setAvailableSeats(20);
//	    schedule.setCost(1500);
//	    airport.setAirportCode("VNS");
//	    airport.setAirportName("LBS");
//	    airport.setAirportLocation("Varanasi");
//	    schedule.setSourceAirport(airport);
//	    schedule.setDestinationAirport(airport);
//	    scheduleFlight.setSchedule(schedule);
//	    service.addScheduleFlight(scheduleFlight);
	}

}

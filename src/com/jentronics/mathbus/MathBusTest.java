package com.jentronics.mathbus;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class MathBusTest {

	public static void main(String[] args) {
		
		LocalTime timer = LocalTime.now();
		
		BusStop stop = new BusStop("Test", 2, timer, 5, 0.25,1);
		for(int i=1; i< 6;i++){
			timer = timer.plusSeconds( i * 60 );
			stop.getRiders(timer, 6);			
		}
		Bus bus = new BusFactory().setBusStartTime(timer).setBusName( "1").build();
		bus.load(5);
		bus.load(60);
		bus.unload(55);
		bus.unload(5);
		bus.unload(1);
		
	}

}

package com.jentronics.mathbus;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class MathBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime timer = LocalTime.now();
		
		BusStop stop = new BusStop(2, timer);
		for(int i=1; i< 6;i++){
			timer = timer.plusSeconds( i * 60 );
			stop.getRiders(timer, 6);			
		}

		Bus bus = new Bus(60, timer);
		bus.load(5);
		bus.load(60);
		bus.unload(55);
		bus.unload(5);
		bus.unload(1);
		
	}

}

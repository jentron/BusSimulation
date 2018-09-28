package com.jentronics.mathbus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BusRoute {
	private List<Bus>     buses = new ArrayList<Bus>();
	private List<BusStop> stops = new ArrayList<BusStop>();
	
	BusRoute(int numberOfBuses, LocalTime startTime, int busIntervalMinutes, int numberOfStops, double ridersPerMinute){
		for(int i=1; i<=numberOfBuses; i++) {
			buses.add(new Bus(60, startTime.plusMinutes(busIntervalMinutes*(i-1)), Integer.toString(i)));
		}
		double drivetime = 0;
		for(int i=1; i <= numberOfStops; i++) {
			stops.add(new BusStop(Integer.toString(i), ridersPerMinute, startTime, drivetime));
			drivetime = 2.5;
		}
	}
	
	public boolean run(){
		for (Bus b : buses) {
			for(BusStop s : stops ) {
				b.drive(s.getDriveTime());
				b.unload(s.removeRiders(b.getTime(), b.getRiders()));
				b.load(s.getRiders(b.getTime(), b.getSpace()));				
			}


		}
		return true;
	}

}

package com.jentronics.mathbus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusRoute {
	private List<Bus>     buses = new ArrayList<Bus>();
	private List<BusStop> stops = new ArrayList<BusStop>();
	
	BusRoute(int numberOfBuses, LocalTime startTime, int busIntervalMinutes, int numberOfStops, double ridersPerMinute){
		for(int i=1; i<=numberOfBuses; i++) {
			buses.add(
				new BusBuilder()
					.setCapacity(60)
					.setBusStartTime(startTime.plusMinutes(busIntervalMinutes*(i-1)))
					.setBusName(Integer.toString(i))
					.build()
			);
		}
		double drivetime = 0;
		for(int i=1; i <= numberOfStops; i++) {
			stops.add(new BusStop(Integer.toString(i), ridersPerMinute, 
					startTime.plusMinutes(3 * (i)-10), drivetime, 0.33));
			drivetime = 1.5;
		}
	}
	
	public boolean run(){
		for(BusStop s : stops ) {
//			Resort buses so they arrive at a stop in temporal order
			Collections.sort(buses, new Comparator<Bus>() {
			    @Override
			    public int compare(Bus lhs, Bus rhs) {
			    //	LocalTime t= lhs.getTime();
			        return lhs.getTime().compareTo(rhs.getTime());
			    }
			});
			for (Bus b : buses) {
				b.drive(s.getDriveTime());
				b.unload(s.removeRiders(b.getTime(), b.getRiders()));
				b.load(s.getRiders(b.getTime(), b.getSpace()));				
			}
		}
		return true;
	}

	public void stopsInfo(){
		for(BusStop s : stops ) {
			s.info();
		}
	}
	
}

package com.jentronics.mathbus;

import java.time.LocalTime;

public class MathBus {

	public static void main(String[] args) {
		int numberOfBuses = 3 ;
		LocalTime startTime = LocalTime.of(7, 30, 01);
		int busIntervalMinutes = 20;
		int numberOfStops = 10;
		double ridersPerMinute = 0.7;
		
		BusRoute route = new BusRoute(numberOfBuses, startTime, busIntervalMinutes, numberOfStops, ridersPerMinute);
		route.stopsInfo();
		route.run();
		//route.run();

	}

}

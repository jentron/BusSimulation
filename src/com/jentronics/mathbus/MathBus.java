package com.jentronics.mathbus;

import java.time.LocalTime;

public class MathBus {

	public static void main(String[] args) {
		int numberOfBuses = 4 ;
		LocalTime startTime = LocalTime.of(7, 30);
		int busIntervalMinutes = 15;
		int numberOfStops = 5;
		double ridersPerMinute = 0.9;
		
		BusRoute route = new BusRoute(numberOfBuses, startTime, busIntervalMinutes, numberOfStops, ridersPerMinute);
		
		route.run();

	}

}

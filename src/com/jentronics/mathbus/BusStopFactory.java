package com.jentronics.mathbus;

import java.time.LocalTime;

public class BusStopFactory {
	private String name = "untitled";
	private int waiting = 0;
	private double riderRate = 10.0; // riders per millisecond
	private LocalTime lastBusTime = null;
	private double weight = 0.25;
	private double driveTime = 1.0;
	
	BusStopFactory name(String name) {
		this.name = name;
		return(this);
	}
	
	BusStopFactory ridersWaiting(int riders) {
		this.waiting = riders;
		return(this);
	}
	
	BusStopFactory riderRatePerMinute(double rate) {
		this.riderRate = rate;
		return(this);
	}

	BusStopFactory riderRatePerHour(double rate) {
		this.riderRate = rate/60.0;
		return(this);
	}

	BusStopFactory lastBusTime(LocalTime time) {
		this.lastBusTime = time;
		return(this);
	}

	BusStopFactory driveTimeMinutes(double time) {
		this.driveTime = time;
		return(this);
	}
	
	BusStopFactory weight(double weight) {
		this.weight = weight;
		return(this);
	}


	BusStop build(){
		return new BusStop(name, riderRate, lastBusTime, driveTime, weight, waiting);
	}

}

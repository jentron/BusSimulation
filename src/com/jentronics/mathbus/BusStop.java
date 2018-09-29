package com.jentronics.mathbus;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.LocalTime;

public class BusStop {
	private String name;
	private final int EMBARK = +1;
	private final int DISEMBARK = -1;
	private int waiting = 0;
	private double riderRate; // riders per millisecond
	private LocalTime lastBusTime;
	private double weight = 0.25;
	private double driveTime = 1.0;
	
	public BusStop(String name, double ridersPerMinute, LocalTime startTime, double driveMinutes, double weight){
		this.lastBusTime = startTime;
		this.riderRate = ridersPerMinute / (60); // convert minutes to seconds
		this.driveTime = driveMinutes;
		this.name = name;
		this.weight = weight;
	}
	
	private void log(LocalTime t, String m, int riders) {
		System.out.printf("Stop %s\tTime\t%s\t%s\t%d\t\tLeft Waiting\t%d\n",
				this.name, t.toString(), m, riders, this.waiting);
	}
	/* Spawn a given number of riders per minute */
	public int getRiders(LocalTime t, int max)
	{
		int riders = (int) (riderRate * ChronoUnit.SECONDS.between(this.lastBusTime, t)) + this.waiting;
		if(riders > max) { // if more passengers want to get on than we have space for
			this.waiting += riders - max; // make them wait
			riders = max; // fill the request
		}
		if(riders > 0 ) {
			this.lastBusTime = t;
		}
		this.log(t, "Passengers Loading", riders);
		return riders;
	}

	/* document riders getting off */
	public int removeRiders(LocalTime t, int riders) {
		int ridersGettingOff = (int) ((double)riders * this.weight);
				this.log(t, "Passengers Unloading", ridersGettingOff);
				return ridersGettingOff;
	}

	public double getDriveTime() {
		return this.driveTime;
	}
}

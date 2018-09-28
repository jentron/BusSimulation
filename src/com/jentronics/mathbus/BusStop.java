package com.jentronics.mathbus;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.LocalTime;

public class BusStop {
	private final int EMBARK = +1;
	private final int DISEMBARK = -1;
	private int waiting = 0;
	private double riderRate; // riders per millisecond
	private LocalTime lastBusTime;
	
	public BusStop(double ridersPerMinute, LocalTime startTime){
		this.lastBusTime = startTime;
		this.riderRate = ridersPerMinute / (60); // convert minutes to seconds
	}
	
	private void log(LocalTime t, int riders, int direction) {
		System.out.printf("BusStop\tTime: %s, Riders: %s, Left Waiting: %d\n",
				t.toString(), (direction*riders), this.waiting);
	}
	/* Spawn a given number of riders per minute */
	public int getRiders(LocalTime t, int max)
	{
		int riders = (int) (riderRate * ChronoUnit.SECONDS.between(this.lastBusTime, t)) + this.waiting;
		if(riders > max) { // if more passengers want to get on than we have space for
			this.waiting += riders - max; // make them wait
			riders = max; // fill the request
		}
		this.lastBusTime = t;
		this.log(t, riders, EMBARK);
		return riders;
	}

	/* document riders getting off */
	public void removeRiders(LocalTime t, int riders) {
				this.log(t, riders, DISEMBARK);
	}
}

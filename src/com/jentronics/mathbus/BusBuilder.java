package com.jentronics.mathbus;

import java.time.LocalTime;

public class BusBuilder {

	private String busName = "Unlabled Bus";
	private int capacity = 60;
	private int riders = 0;
	private double loadTimeSeconds = 10.0;
	private double unloadTimeSeconds = 5.0;
	private LocalTime startTime;

	BusBuilder setBusName(String busName) {
		this.busName = busName;
		return this;
	}

	BusBuilder setCapacity(Integer capacity) {
		this.capacity = capacity;
		return this;
	}

	BusBuilder setRiders(Integer riders) {
		this.riders = riders;
		return this;
	}
	
	BusBuilder setLoadTimeSeconds( double loadTimeSeconds) {
		this.loadTimeSeconds = loadTimeSeconds;
		return this;
	}
	
	BusBuilder setUnloadTimeSeconds( double unloadTimeSeconds){
		this.unloadTimeSeconds = unloadTimeSeconds;
		return this;
	}
		
	BusBuilder setBusStartTime (LocalTime startTime) {
		this.startTime = startTime;
		return this;
	}
	
	Bus build() {
		return new Bus(busName, capacity, riders, loadTimeSeconds, unloadTimeSeconds, startTime);
	}
}

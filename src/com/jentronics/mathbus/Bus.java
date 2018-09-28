package com.jentronics.mathbus;

import java.time.LocalTime;

public class Bus {
	private int capacity;
	private int riders = 0;
	private double loadTimeSeconds = 10.0;
	private double unloadTimeSeconds = 5.0;
	private LocalTime busTime;
	
	Bus(int cap, LocalTime start){
		this.capacity = cap;
		this.busTime = start;
	}
	
	private void log(String m, int r, long t, int err){
		System.out.printf("%s %d passengers in %d seconds, leaving %d. Complete at %s\n",
				m, r, t, err, this.busTime.toString());
	}
	public int unload(int r) {
		int err = 0;
		if(r > this.riders){
			err = r - this.riders;
			r = this.riders;
		}
		this.riders -= r;
		long loadTime = (long) (r * this.unloadTimeSeconds);
		this.busTime = this.busTime.plusSeconds((long) (r * this.unloadTimeSeconds));
		this.log("Unloaded", r, loadTime, err);
		return err;
	}
	
	public int load(int r){
		int err = 0;
		if(r + this.riders > this.capacity){
			err = r - (this.capacity - this.riders);
			r = (this.capacity - this.riders);
		}
		this.riders += r;
		long loadTime = (long) (r * this.loadTimeSeconds);
		this.busTime = this.busTime.plusSeconds(loadTime);
		this.log("Loaded", r, loadTime, err);
		return err;
	}
}

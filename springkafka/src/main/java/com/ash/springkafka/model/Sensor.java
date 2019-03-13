package com.ash.springkafka.model;

public class Sensor {

	private int id;
	private int lat;
	private int lon;
	private int tmp;
	
	
	
	public Sensor(int id, int lat, int lon, int tmp) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.tmp = tmp;
	}
	public int getId() {
		return id;
	}
	public int getLat() {
		return lat;
	}
	public int getLon() {
		return lon;
	}
	public int getTmp() {
		return tmp;
	}
	
	
}

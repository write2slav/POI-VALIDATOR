package com.ponezha.slava.google.poi.validator;

public class PointOfInterest {
	public String id;
	public String name;
	public String address;
	public Boolean validPoi;

	public PointOfInterest(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.validPoi = false;
	}

}

package com.ponezha.slava.google.poi.validator;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;

public class PoiListBuilder {

	ArrayList<PointOfInterest> pois = new ArrayList<PointOfInterest>();

	public PoiListBuilder() {
		// TODO Auto-generated constructor stub

		String csvFile = "/Users/slava/Desktop/POIs.csv";

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;
			while ((line = reader.readNext()) != null) {
				System.out.println("ID = " + line[0] + ", NAME = " + line[1] + " , Address = " + line[2]);
				this.pois.add(new PointOfInterest(line[0], line[1], line[2]));
				// new PointOfInterest(line[0],line[1],line[2]);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	ArrayList<PointOfInterest> getListOfPois() {

		return this.pois;

	}

}

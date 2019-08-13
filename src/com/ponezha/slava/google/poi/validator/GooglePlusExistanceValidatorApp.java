package com.ponezha.slava.google.poi.validator;

import java.util.ArrayList;

public class GooglePlusExistanceValidatorApp {

	public static void main(String[] args) throws InterruptedException {

		PoiListBuilder poiListBulder = new PoiListBuilder();

		Validator poiValidator = new Validator();
		ArrayList<PointOfInterest> poiList = poiValidator.getValidPoiId(poiListBulder.getListOfPois());
		System.out.println("Found updated :" + poiList.size());

		for (PointOfInterest poi : poiList) {
			System.out.println("Found updated :" + poi.id);

		}

		poiValidator.stop();

	}

}

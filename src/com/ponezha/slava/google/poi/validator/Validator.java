package com.ponezha.slava.google.poi.validator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validator {
	WebDriver driver;
	ArrayList<PointOfInterest> listOfValidPoi = new ArrayList<PointOfInterest>();

	public Validator() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/slava/Desktop/WebDrivers/chromedriver");

		this.driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		String baseUrl = "http://google.com/";
		driver.get(baseUrl);
		Thread.sleep(100); // Wait

	}

	public ArrayList<PointOfInterest> getValidPoiId(List<PointOfInterest> listOfPois) {
		System.out.println("Got POI to validate :"+listOfPois.size());
		for (PointOfInterest poi : listOfPois) {

			try {

				driver.findElement(By.xpath("//*[@type='text']")).clear();
				driver.findElement(By.xpath("//*[@type='text']")).sendKeys(poi.name + " " + poi.address);

				Thread.sleep(100);

				driver.findElement(By.xpath("//*[@type='text']")).sendKeys(Keys.ENTER);
				Thread.sleep(500); // Wait

				driver.findElements(By.xpath("//*[contains(text(),'Google reviews')]")).get(0).click();

				Thread.sleep(500); // Wait

				driver.findElement(By.xpath("//*[contains(text(),'Most r')]")).click();

				Thread.sleep(500); // Wait

				driver.findElement(By.xpath("//*[contains(text(),\"Newest\")]")).click();

				Thread.sleep(500); // Wait

				List<WebElement> reviewList = driver.findElements(By.xpath(
						"//*[@id='reviewSort']//*[contains(text(),'day') or contains(text(), 'week') or contains(text(), 'month')]/ancestor::*[position() = 1]/following-sibling::*"));

				for (WebElement review : reviewList) {

					if (review.getText().length() > 5) {
						System.out.print("👍 Found POI wirth a review within 12 months: ");
						System.out.println(review.getText());
						poi.validPoi = true;
						listOfValidPoi.add(poi);

						break;
					}

				}

			} catch (Exception ignore) {
				
				//ignore.printStackTrace();

			}

		}
		return listOfValidPoi;
	}

	// Driver quite
	public void stop() {
		driver.quit();
	}

}

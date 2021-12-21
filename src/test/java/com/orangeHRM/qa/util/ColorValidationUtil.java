package com.orangeHRM.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ColorValidationUtil {

	public static String GetColor(WebElement element) {

		String elemcolor = element.getCssValue("background-color");
		String hexcolor = Color.fromString(elemcolor).asHex();
		String color = null;
		switch (hexcolor) {

		case "#33ac3f":
			System.out.println("Color of the WebElement is Green");
			color = "Green";
			break;

		case "#aa4935":
			System.out.println("Color of the WebElement is Red");
			color = "Red";
			break;
		case "#ababab":
			System.out.println("Color of the WebElement is Light Grey");
			color = "Light Grey";
			break;
		case "#f28c38":
			System.out.println("Color of the WebElement is Orange");
			color = "Orange";
			break;
		case "#5d5d5d":
			System.out.println("Color of the WebElement is Darkest Grey");
			color = "Darkest Grey";
			break;
		case "#848484":
			System.out.println("Color of the WebElement is Darker Grey");
			color = "Darker Grey";
			break;

		}
		return color;
	}

}

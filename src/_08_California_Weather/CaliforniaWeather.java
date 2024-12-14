package _08_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather {

	void start() {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

		String city = JOptionPane.showInputDialog("Enter a city name");

		WeatherData datum = weatherData.get(city);

		if( datum == null ) {
			System.out.println("Unable to find weather data for: " + city);
		} else {
			System.out.println(city + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}

		String condition = JOptionPane.showInputDialog("Enter a weather condition");
		for(Entry<String, WeatherData> e : weatherData.entrySet()) {
			if(condition.equals(e.getValue().weatherSummary)) {
				System.out.println(e.getKey()); 		   
			}
		}

		String min = JOptionPane.showInputDialog("Enter a minimum temperature");
		String max = JOptionPane.showInputDialog("Enter a maximum temperature");
		
		double minTemp = Double.parseDouble(min);
		double maxTemp = Double.parseDouble(max);
		
		for(Entry<String, WeatherData> i : weatherData.entrySet()) {
			if(minTemp <= i.getValue().temperatureF && maxTemp >= i.getValue().temperatureF) {
				System.out.println(i.getKey());
			}
		}
		
	}
}

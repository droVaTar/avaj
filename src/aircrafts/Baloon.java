package src.aircrafts;

import src.weather.WeatherTower;
import src.interfaces.Flyable;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower wheatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		System.out.println(name);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}

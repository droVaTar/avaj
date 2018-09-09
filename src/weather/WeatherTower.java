package src.weather;

import src.aircrafts.Coordinates;

public class WeatherTower extends Tower
{
	WeatherProvider weather;

	WeatherTower ()
	{
		super();
		weather = WeatherProvider.getProvider();
	}

	public String getWeather(Coordinates coordinates)
	{
		return (weather.getCurrentWeather(coordinates));
	}

	private void changeWeather()
	{
		
	}
}
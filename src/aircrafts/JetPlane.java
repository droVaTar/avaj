package src.aircrafts;

import src.weather.WeatherTower;
import src.interfaces.Flyable;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String	weather = weatherTower.getWeather(coordinates);

		int		longtitude = coordinates.getLongitude();
		int		latitude = coordinates.getLatitude();
		int		height = coordinates.getHeight();

		if (weather.equals("SUN"))
		{
			latitude += 10;
			height += 2;
		}
		else if (weather.equals("RAIN"))
		{
			latitude += 5;
		}
		else if (weather.equals("FOG"))
		{
			latitude += 1;
		}
		else if (weather.equals("SNOW"))
		{
			height -= 7;
		}
		else
		{
			System.out.println("Error weather name");
			System.exit(0);
		}

		if (height > 100)
			height = 100;
		if (height <= 0)
			weatherTower.unregister(this);

		coordinates = new Coordinates(longtitude, latitude, height);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}
}

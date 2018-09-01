package src.aircrafts;

import src.weather.WeatherTower;
import src.interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower wheatherTower;

    Helicopter(String name, Coordinates coordinates)
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

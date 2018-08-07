package src.interfaces;

import src.weather.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}

package src.weather;

import src.aircrafts.Coordinates;

public class WeatherProvider
{
   private WeatherProvider wheatherProvider;
   private String[] wheather;

   private WeatherProvider()
   {

   }

   public WeatherProvider getProvider()
   {
       return (this.wheatherProvider);
   }

   public String getCurrentWeather(Coordinates coordinates)
   {
      return (null);
   }

}

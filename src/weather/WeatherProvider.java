package src.weather;

import src.aircrafts.Coordinates;

public class WeatherProvider
{
   private static WeatherProvider weatherProvider = new WeatherProvider();
   private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

   private WeatherProvider()
   {

   }

   public static WeatherProvider getProvider()
   {
      return (weatherProvider);
   }

   public String getCurrentWeather(Coordinates coordinates)
   {
      int index;

      index = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
      index = index % 4;
      return (weather[index]);
   }

}

package src.weather;

import src.aircrafts.Coordinates;

public class WeatherProvider
{
   private static WeatherProvider weatherProvider;
   private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

   private WeatherProvider()
   {

   }

   public static WeatherProvider getProvider()
   {
      if (this.weatherProvider == null)
         this.weatherProvider = new WeatherProvider();

      return (this.weatherProvider);
   }

   public String getCurrentWeather(Coordinates coordinates)
   {
      int index;

      index = (coordinates.getLongtitude() + coordinates.getLatitude()) * coordinates.getHeight();
      index = index % 4;
      return (weather[index]);
   }

}

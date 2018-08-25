package src.aircrafts;

import src.interfaces.Flyable;

public class AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitute, int latitute, int height)
    {
    	Coordinates coords = new Coordinates(longitute, latitute, height);

    	if (!type.equals("Baloon"))
    		return (new Baloon(type, coords));

    	if (!type.equals("JetPlane"))
    		return (new Baloon(type, coords));

    	if (!type.equals("Helicopter"))
    		return (new Baloon(type, coords));

        return (null);
    }
}
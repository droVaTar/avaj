package src.weather;

import src.interfaces.Flyable;
import java.util.*;

public class Tower implements Flyable
{
	private List<Flyable> observes;

	Tower()
	{
		observes = new ArrayList<Flyable>();
	}
	
	public void register(Flyable flyable)
	{
		observes.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		observes.remove(flyable);
	}

	protected void conditionsChanged()
	{

	}

	public void updateConditions()
	{
		for (Flyable flyable : observes)
		{
			flyable.updateConditions();
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		for (Flyable flyable : observes)
		{
			flyable.registerTower(weatherTower);
		}
	}
}

package src.start;

import src.exceptions.Errors;
import src.interfaces.Flyable;
import src.aircrafts.AircraftFactory;

import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Integer;
import java.util.*;

public class StartProgram
{
	private static AircraftFactory aircraftFactory;

    public static void main(String[] args) 
    {
    	aircraftFactory = new AircraftFactory();
		try
		{
			BufferedReader br = checkOpenFile(args);
			checkValidFile(br);
		}
		catch (Errors e)
		{
			System.out.print("Error my: ");
			e.printMessage();
		}
		catch (Exception ee) 
		{
			System.out.print("Error standart: ");
			ee.printStackTrace();
			// System.out.println(e);
		}
		System.out.println("END");
	}

	private static int parceNumber(String str)
	{
		int ret = -1;
		Integer k;

		try
		{
			k = new Integer(str);
			ret = k.intValue();
		}
		catch (NumberFormatException e)
		{}
		return (ret);
	}

	private static Flyable parceLine(String[] params, int line) throws Exception
	{
		if (params.length != 5)
			throw new Errors("Line with Aircraft params must have 5 params. Type, Name, Longtitude, Latitude, Height", line);

		Flyable ret = null;
		String type = params[0];
		String name = params[1];
		int longtitude = parceNumber(params[2]);
		int latitude = parceNumber(params[3]);
		int height = parceNumber(params[4]);

		if (longtitude < 0)
			throw new Errors("Longtitude " + params[2] + " is forbidden.\nYou can set only positive integer number", line);

		if (latitude < 0)
			throw new Errors("Latitude " + params[3] + " is forbidden.\nYou can set only positive integer number", line);

		if (height < 0)
			throw new Errors("Height " + params[4] + " is forbidden.\nYou can set only positive integer number", line);

		if (height > 100)
			height = 100;

		ret = aircraftFactory.newAircraft(type, name, latitude, longtitude, height);
		if (ret == null)
			throw new Errors("Type " + type + " is forbidden.\nYou can set type one of this: Baloon, JetPlane, Helicopter", line);

		System.out.println("add +" + type);
		return (ret);
	}

	private static void checkValidFile(BufferedReader br) throws Exception
	{
		int counterChange;
		String buf = br.readLine();
		ArrayList<Flyable> aircrafts = new ArrayList<Flyable>();

		checkFirstLine(buf);
		if (!isOnlyDigits(buf) || (counterChange = parceNumber(buf)) < 0)
			throw new Errors("Line must have only positive integer number", 0);
		
		for (int counterLines = 1; (buf = br.readLine()) != null; counterLines++)
		{
			aircrafts.add(parceLine(buf.split(" "), counterLines));
			// aircrafts.get(counterLines - 1).updateConditions();
		}
	}

	private static BufferedReader checkOpenFile(String[] args) throws Exception
	{
		FileReader fr = null;
		BufferedReader br = null;

		if (args.length < 1)
			throw new Errors("No such arguments");
		try
		{
			fr = new FileReader(args[0]);
			br = new BufferedReader(fr);
		}
		catch (Exception e)
		{}
		finally
		{
			if (fr == null || br == null)
				throw new Errors("Error in open file");
		}
		return (br);
	}

	private static void checkFirstLine(String str) throws Exception
	{
		if (!isOnlyDigits(str))
			throw new Errors("Not valid number"); 
	}

	private static boolean isOnlyDigits(String str) {
        return str.matches("[\\d]+");
    }
}

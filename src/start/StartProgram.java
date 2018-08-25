package src.start;

import src.exceptions.Errors;

import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Integer;

public class StartProgram
{

    public static void main(String[] args) 
    {
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
		catch (Exception e) 
		{
			System.out.print("Error standart: ");
			System.out.println(e);
		}
		System.out.println("END");
	}

	private static int parceNumber(String str)
	{
		int ret = -1;
		Integer k;

		System.out.println(str + " -str;");


		try
		{
			k = new Integer(str);
			ret = k.intValue();
			// ret = Integer.parceInt(str);
		}
		catch (NumberFormatException e)
		{}
		return (ret);
	}

	private String parceType(String str)
	{
		return (null);
	}

	private static void checkValidFile(BufferedReader br) throws Exception
	{
		int counterChange;
		String buf = br.readLine();

		checkFirstLine(buf);
		if (!isOnlyDigits(buf) || (counterChange = parceNumber(buf)) < 0)
			throw new Errors("Error: First line must have only positive integer number");
		
		while ((buf = br.readLine()) != null)
		{
			String params[] = buf.split(" ");
			for (String str : params) {
				System.out.println(str);
			}
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

package src.start;

import src.exceptions.Errors;

import java.io.FileReader;
import java.io.BufferedReader;

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

	private static void checkValidFile(BufferedReader br) throws Exception
	{
		String inside_file = "";
		String buf = br.readLine();
		checkFirstLine(buf);
		inside_file += buf + "\n";

		while ((buf = br.readLine()) != null)
		{
			inside_file += buf;
			if (isOnlyDigits(buf))
				inside_file += "true\n";
			else
				inside_file += "false\n";
		}
		System.out.println(inside_file);
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

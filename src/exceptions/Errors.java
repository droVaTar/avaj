package src.exceptions;

public class Errors extends Exception
{
    private String message;

    public Errors(String message) throws Exception
    {
        this.message = message;
    }

    public Errors(String message, int line) throws Exception
    {
        this.message = "Error: Line " + line + ". " + message;
    }

    public Errors() throws Exception
    {
        this.message = "Error";
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void printMessage()
    {
        System.out.println(this.message);
    }

    public void setErrorFirstLine()
    {
        this.message = "Error: First line must have only positive integer number";
    }

    public void setErrorTypeFlyable(String type)
    {
        this.message = "Error: type " + type + " is forbidden.\nYou can set type one of this: Baloon, JetPlane, Helicopter";
    }
}

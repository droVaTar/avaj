package src.exceptions;

public class Errors extends Exception
{
    private String message;

    public Errors(String message) throws Exception
    {
        this.message = message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void printMessage()
    {
        System.out.println(this.message);
    }
}

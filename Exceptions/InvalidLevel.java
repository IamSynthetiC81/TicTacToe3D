package Exceptions;

    public class InvalidLevel extends Exception{
    private static String ErrMessage = "newLevel is invompatible whith the CurrLevel";

    public InvalidLevel(){
        super(ErrMessage);
    }

    public InvalidLevel(Throwable r) {
        super(ErrMessage, r);
    }
}

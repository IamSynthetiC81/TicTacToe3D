package Exceptions;

public class LevelOutOfBounds extends Exception {
    String ErrorMessage = "The current level is invalid";

    public LevelOutOfBounds(){
        super("The level is out of bounds");
    }   
}

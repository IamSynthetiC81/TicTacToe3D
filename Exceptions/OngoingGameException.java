package Exceptions;

public class OngoingGameException extends Exception {
    
    public OngoingGameException(){
        super();
    }

    public OngoingGameException(String ErrorMessage){
        super(ErrorMessage);
    }

    public OngoingGameException(String ErrorMessage, Throwable err){
        super(ErrorMessage, err);
    }

}

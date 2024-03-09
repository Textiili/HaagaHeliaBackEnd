package hh.sof3.bookstore.web;

public class CustomExceptionMessage extends RuntimeException{
    public CustomExceptionMessage(String message) {
        super(message);
    }
}

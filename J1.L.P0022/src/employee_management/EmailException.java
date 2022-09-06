package employee_management;

public class EmailException extends RuntimeException{
    public EmailException (String err){
        super(err);
    }
}

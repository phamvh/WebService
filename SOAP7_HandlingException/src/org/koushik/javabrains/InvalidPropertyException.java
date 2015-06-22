package org.koushik.javabrains;

/**
 * Created by van on 6/20/15.
 */
public class InvalidPropertyException extends Exception{

    private String errorDetails;

    public InvalidPropertyException(String reason, String errorDetails){
        super(reason);
        this.errorDetails = errorDetails;
    }

    public String getErrorInfo(){
        return  errorDetails;
    }
}


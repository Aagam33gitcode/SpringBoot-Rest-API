package com.example.springComplete.Exception;



public class ResourceNotFoundException extends RuntimeException{
public ResourceNotFoundException(String msg){
    super(msg);
}
public static class ResourceAlreadyExistsException extends ResourceNotFoundException{
    public ResourceAlreadyExistsException(String msg){
        super(msg);
    }
}

}


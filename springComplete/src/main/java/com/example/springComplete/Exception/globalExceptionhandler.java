package com.example.springComplete.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class globalExceptionhandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> getCustomExcetption(ResourceNotFoundException ex){
    ApiError error=new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
    @ExceptionHandler(ResourceNotFoundException.ResourceAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleEmployeeAlreadyExists(ResourceNotFoundException.ResourceAlreadyExistsException ex) {
        ApiError error = new ApiError(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

   /* @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> resouceNotFoundError(NoSuchElementException exception){
        return new ResponseEntity<>("employee not have exist", HttpStatus.NOT_FOUND);
    }


    for the some messages/error details
        @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resouceNotFoundError(ResourceNotFoundException exception){
ApiError apiError=ApiError.bulider().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleCustomException(ResourceNotFoundException exception){
        return new ResponseEntity<>(exception.message,exception.getStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleCustomException1(IllegalArgumentException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleCustomException1(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
*/


}

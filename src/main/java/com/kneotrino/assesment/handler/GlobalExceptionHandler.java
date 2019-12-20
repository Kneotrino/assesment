package com.kneotrino.assesment.handler;

import com.kneotrino.assesment.exception.DuplicateEntryException;
import com.kneotrino.assesment.exception.PasswordNotValidException;
import com.kneotrino.assesment.exception.ResourceNotFoundException;
import com.kneotrino.assesment.exception.SqlException;
import com.kneotrino.assesment.response.MessageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked", "rawtypes"})
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity resourceNotFoundHandlerException(Exception ex, WebRequest request) {

    return new ResponseEntity(new MessageResponse(ex.getMessage(), "Resource Not Found"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicateEntryException.class)
  public ResponseEntity duplicateEntryHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), "DuplicateEntry"), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(SqlException.class)
  public ResponseEntity sqlHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), "Database connection error"), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(PasswordNotValidException.class)
  public ResponseEntity passwordNotValidHandlerException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), "Password not Valid"), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity methodArgumentNotValidException(Exception ex, WebRequest request) {
    return new ResponseEntity(new MessageResponse(ex.getMessage(), "Username or Password mismatch"), HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    return new ResponseEntity(new MessageResponse("Argument sign up not Valid", ex.getClass().toGenericString()), HttpStatus.BAD_REQUEST);
  }

}
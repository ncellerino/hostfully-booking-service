package com.hostfully.booking.common;

import com.hostfully.booking.entities.ApiResponse;
import com.hostfully.modules.booking.domain.exceptions.BookingAlreadyCancelledException;
import com.hostfully.modules.booking.domain.exceptions.DomainException;
import com.hostfully.modules.booking.domain.exceptions.InvalidDateRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = {DomainException.class})
  ResponseEntity<ApiResponse> handleDomainException(DomainException ex) {
    return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {InvalidDateRangeException.class})
  ResponseEntity<ApiResponse> handleInvalidBlockDateRangeException(InvalidDateRangeException ex) {
    return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {BookingAlreadyCancelledException.class})
  ResponseEntity<ApiResponse> handleBookingAlreadyCancelledException(
      BookingAlreadyCancelledException ex) {
    return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
  }
}

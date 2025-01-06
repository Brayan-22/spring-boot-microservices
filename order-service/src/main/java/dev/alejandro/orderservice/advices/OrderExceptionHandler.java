package dev.alejandro.orderservice.advices;

import dev.alejandro.orderservice.dto.CustomErrorResponseDTO;
import dev.alejandro.orderservice.dto.GlobalErrorCode;
import dev.alejandro.orderservice.exceptions.EmptyCollectionException;
import dev.alejandro.orderservice.exceptions.ParsingObjectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class OrderExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponseDTO error = new CustomErrorResponseDTO(
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                GlobalErrorCode.ERROR_ILLEGAL_ARGUMENT
        );
        log.error("{}::handleIllegalArgumentException exception caught: {}",this.getClass().getName(),e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmptyCollectionException.class)
    public ResponseEntity<?> handleEmptyCollectionException(EmptyCollectionException e){
        CustomErrorResponseDTO error = new CustomErrorResponseDTO(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                GlobalErrorCode.ERROR_EMPTY_COLLECTION
        );
        log.error("{}::handleEmptyCollectionException exception caught: {}",this.getClass().getName(),e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ParsingObjectException.class)
    public ResponseEntity<?> handleParsingObjectException(ParsingObjectException e){
        CustomErrorResponseDTO error = new CustomErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                GlobalErrorCode.ERROR_PARSING_DATA
        );
        log.error("{}::handleParsingObjectException exception caught: {}",this.getClass().getName(),e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

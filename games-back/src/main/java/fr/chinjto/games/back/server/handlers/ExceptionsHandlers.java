package fr.chinjto.games.back.server.handlers;

import fr.chinjto.games.back.business.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@ControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ProblemDetail> hanbleBusinessException(final BusinessException businessException) {
        return buildResponse(businessException.getMessage(), businessException.getStatus());
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<ProblemDetail> hanbleGenericException(final NoResourceFoundException noResourceFoundException) {
        return buildResponse(NOT_FOUND.getReasonPhrase(), NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ProblemDetail> hanbleGenericException(final Exception exception) {
        log.error("Exception non gérée levée par l'application :", exception);
        return buildResponse("Technical Exception", INTERNAL_SERVER_ERROR);
    }

    private static ResponseEntity<ProblemDetail> buildResponse(final String message, final HttpStatus httpStatus) {
        return new ResponseEntity<>(buildProblem(message, httpStatus), httpStatus);
    }

    private static ProblemDetail buildProblem(final String message, final HttpStatus httpStatus) {
        return ProblemDetail.forStatusAndDetail(httpStatus, message);
    }

}

package fr.chinjto.games.back.business.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatus status;

    public BusinessException(final HttpStatus status, final String message) {
        super(message);
        this.status = status;
    }

    public BusinessException(final HttpStatus status, final String message, final Throwable cause) {
        super(message, cause);
        this.status = status;
    }

}

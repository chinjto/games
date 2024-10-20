package fr.chinjto.games.back.server.exceptions;

import fr.chinjto.games.back.business.exceptions.BusinessException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public class ResourceNotImplementedException extends BusinessException {

    public static final String EXCEPTION_MESSAGE = "Resource not yet implemented.";

    public ResourceNotImplementedException() {
        super(NOT_FOUND, EXCEPTION_MESSAGE);
    }

    public ResourceNotImplementedException(final Throwable cause) {
        super(NOT_FOUND, EXCEPTION_MESSAGE, cause);
    }

}

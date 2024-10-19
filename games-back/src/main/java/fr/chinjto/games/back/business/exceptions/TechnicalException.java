package fr.chinjto.games.back.business.exceptions;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public class TechnicalException extends BusinessException {

    private static final String EXCEPTION_MESSAGE = "Technical Exception";

    public TechnicalException() {
        super(INTERNAL_SERVER_ERROR, EXCEPTION_MESSAGE);
    }

    public TechnicalException(final Throwable cause) {
        super(INTERNAL_SERVER_ERROR, EXCEPTION_MESSAGE, cause);
    }

}

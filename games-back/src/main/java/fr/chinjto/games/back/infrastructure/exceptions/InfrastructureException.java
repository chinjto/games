package fr.chinjto.games.back.infrastructure.exceptions;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public class InfrastructureException extends RuntimeException {

    public InfrastructureException(final String message) {
        super(message);
    }

    public InfrastructureException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

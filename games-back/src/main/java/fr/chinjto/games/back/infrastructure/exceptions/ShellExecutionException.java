package fr.chinjto.games.back.infrastructure.exceptions;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public class ShellExecutionException extends InfrastructureException {

    public ShellExecutionException(final String message) {
        super(message);
    }

    public ShellExecutionException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

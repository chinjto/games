package fr.chinjto.games.back.infrastructure.systems.linux.shell.impl;

import fr.chinjto.games.back.infrastructure.exceptions.ShellExecutionException;
import fr.chinjto.games.back.infrastructure.systems.linux.shell.Arguments;
import fr.chinjto.games.back.infrastructure.systems.linux.shell.LinuxProcess;
import fr.chinjto.games.back.infrastructure.systems.linux.shell.ShellManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static fr.chinjto.games.back.infrastructure.systems.linux.shell.LinuxProcess.SUDO;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@Component
@Profile("!dev")
public class ShellManagerProdImpl implements ShellManager {

    public void execute(final LinuxProcess linuxProcess, final String... args) {
        this.execute(getArguments(linuxProcess, args));
    }

    public void executeAsSudo(final LinuxProcess linuxProcess, final String... args) {
        this.execute(getArguments(linuxProcess, args)
                .prepend(SUDO.getName())
        );
    }

    private static Arguments getArguments(LinuxProcess linuxProcess, String[] args) {
        return new Arguments(args)
            .prepend(linuxProcess.getName());
    }

    protected void execute(final Arguments args) {
        final ProcessBuilder processBuilder = new ProcessBuilder(args.values());
        processBuilder.redirectErrorStream(true);
        try {
            final Process executionProcess = processBuilder.start();
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(executionProcess.getInputStream()))) {
                reader.lines().forEach(log::trace);
            }
            int exitCode = executionProcess.waitFor();
            log.trace("Exited with code: {}", exitCode);
        } catch (IOException | InterruptedException e) {
            final String message = String.format("Erreur lors de l'exécution de la commande shell \"%s\".", args);
            throw new ShellExecutionException(message, e);
        }
    }

}

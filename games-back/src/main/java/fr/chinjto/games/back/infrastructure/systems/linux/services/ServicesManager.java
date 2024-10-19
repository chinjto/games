package fr.chinjto.games.back.infrastructure.systems.linux.services;

import fr.chinjto.games.back.business.exceptions.TechnicalException;
import fr.chinjto.games.back.infrastructure.exceptions.InfrastructureException;
import fr.chinjto.games.back.infrastructure.systems.linux.shell.ShellManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static fr.chinjto.games.back.infrastructure.systems.linux.services.Task.RESTART;
import static fr.chinjto.games.back.infrastructure.systems.linux.services.Task.START;
import static fr.chinjto.games.back.infrastructure.systems.linux.services.Task.STOP;
import static fr.chinjto.games.back.infrastructure.systems.linux.shell.LinuxProcess.SYSTEM_CTL;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ServicesManager {

    private final ShellManager shellManager;

    public void start(final Service service) {
        execute(START, service);
    }

    public void restart(final Service service) {
        execute(RESTART, service);
    }

    public void stop(final Service service) {
        execute(STOP, service);
    }

    private void execute(final Task action, final Service service) {
        try {
            this.shellManager.executeAsSudo(SYSTEM_CTL, action.getName(), service.getName());
        } catch (final InfrastructureException ie) {
            log.error(ie.getMessage(), ie);
            throw new TechnicalException(ie);
        }
    }

}

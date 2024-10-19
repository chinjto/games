package fr.chinjto.games.back.infrastructure.steam.cmd;

import fr.chinjto.games.back.business.exceptions.TechnicalException;
import fr.chinjto.games.back.infrastructure.exceptions.InfrastructureException;
import fr.chinjto.games.back.infrastructure.steam.apps.Application;
import fr.chinjto.games.back.infrastructure.systems.linux.shell.ShellManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static fr.chinjto.games.back.infrastructure.systems.linux.shell.LinuxProcess.STEAM_CMD;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SteamManager {

    private final ShellManager shellManager;

    public void update(final Application application) {
        this.execute(SteamCommandBuilder.create()
            .login("anonymous")
            .update(application)
            .updateAndValidate(application)
            .quit()
        );
    }

    private void execute(final SteamCommand command) {
        try {
            this.shellManager.execute(STEAM_CMD, command.build());
        } catch (final InfrastructureException ie) {
            log.error(ie.getMessage(), ie);
            throw new TechnicalException(ie);
        }
    }

}

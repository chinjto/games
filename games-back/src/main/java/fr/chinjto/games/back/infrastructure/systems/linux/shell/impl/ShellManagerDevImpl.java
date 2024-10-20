package fr.chinjto.games.back.infrastructure.systems.linux.shell.impl;

import fr.chinjto.games.back.infrastructure.systems.linux.shell.Arguments;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@Component
@Profile("dev")
@RequiredArgsConstructor
public class ShellManagerDevImpl extends ShellManagerProdImpl {

    private final ShellMocksProperties mocksProperties;

    @Override
    protected void execute(Arguments args) {
        log.trace(" |------ DEV MOCK ------|");
        log.trace(" | Mock demandé : {}", args);
        log.trace(" | Simulation du traitement pendant {}ms...", mocksProperties.sleep());
        try {
            Thread.sleep(mocksProperties.sleep());
        } catch (final InterruptedException te) {
            log.error("Thread de pause interrompu par le système.", te);
        }
        log.trace(" |------ END MOCK ------");
    }

}

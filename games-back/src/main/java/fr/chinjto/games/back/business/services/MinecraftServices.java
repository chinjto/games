package fr.chinjto.games.back.business.services;

import fr.chinjto.games.back.infrastructure.systems.linux.services.ServicesManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static fr.chinjto.games.back.infrastructure.systems.linux.services.Service.MINECRAFT;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Service
@RequiredArgsConstructor
public class MinecraftServices {

    private final ServicesManager servicesManager;

    public void start() {
        this.servicesManager.start(MINECRAFT);
    }

    public void restart() {
        this.servicesManager.restart(MINECRAFT);
    }

    public void stop() {
        this.servicesManager.stop(MINECRAFT);
    }

}

package fr.chinjto.games.back.business.services;

import fr.chinjto.games.back.infrastructure.steam.cmd.SteamManager;
import fr.chinjto.games.back.infrastructure.systems.linux.services.ServicesManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static fr.chinjto.games.back.infrastructure.steam.apps.Application.PALWORLD_SERVER;
import static fr.chinjto.games.back.infrastructure.systems.linux.services.Service.PALWORLD;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Service
@RequiredArgsConstructor
public class PalworldServices {

    private final ServicesManager servicesManager;

    private final SteamManager steamManager;

    public void start() {
        this.servicesManager.start(PALWORLD);
    }

    public void restart() {
        this.servicesManager.restart(PALWORLD);
    }

    public void stop() {
        this.servicesManager.stop(PALWORLD);
    }

    public void update() {
        steamManager.update(PALWORLD_SERVER);
    }

}

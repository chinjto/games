package fr.chinjto.games.back.infrastructure.steam.cmd;

import fr.chinjto.games.back.infrastructure.steam.apps.Application;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public class SteamCommand {

    private final StringBuilder commandBuilder = new StringBuilder();

    public SteamCommand login(final String user) {
        commandBuilder.append(" +login ").append(user);
        return this;
    }

    public SteamCommand update(final Application application) {
        commandBuilder.append(" +update ").append(application.getId());
        return this;
    }

    public SteamCommand updateAndValidate(final Application application) {
        commandBuilder.append(" +update ").append(application.getId()).append(" validate");
        return this;
    }

    public SteamCommand quit() {
        commandBuilder.append(" +quit");
        return this;
    }

    public String build() {
        return commandBuilder.toString();
    }

}

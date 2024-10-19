package fr.chinjto.games.back.infrastructure.steam.cmd;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SteamCommandBuilder {

    public static SteamCommand create() {
        return new SteamCommand();
    }

}

package fr.chinjto.games.back.infrastructure.steam.apps;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
@AllArgsConstructor
public enum Application {

    PALWORLD_SERVER(2394010L);

    private final Long id;

}

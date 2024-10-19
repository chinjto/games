package fr.chinjto.games.back.infrastructure.systems.linux.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
@RequiredArgsConstructor
public enum Service {

    MINECRAFT("minecraft"),
    PALWORLD("palworld");

    private final String name;

}

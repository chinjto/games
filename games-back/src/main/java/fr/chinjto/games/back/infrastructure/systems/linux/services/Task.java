package fr.chinjto.games.back.infrastructure.systems.linux.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
@AllArgsConstructor
public enum Task {

    START("start"),
    RESTART("restart"),
    STOP("stop");

    private final String name;

}

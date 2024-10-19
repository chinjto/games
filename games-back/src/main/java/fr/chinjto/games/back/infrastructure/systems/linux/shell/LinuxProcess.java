package fr.chinjto.games.back.infrastructure.systems.linux.shell;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
@AllArgsConstructor
public enum LinuxProcess {

    SUDO("sudo"),
    STEAM_CMD("steamcmd"),
    SYSTEM_CTL("systemctl");

    private final String name;

}

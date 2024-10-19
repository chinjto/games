package fr.chinjto.games.back.infrastructure.systems.linux.shell;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
public interface ShellManager {

    void execute(final LinuxProcess linuxProcess, final String... args);

    void executeAsSudo(final LinuxProcess linuxProcess, final String... args);

}

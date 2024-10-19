package fr.chinjto.games.back.infrastructure.systems.linux.shell.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@ConfigurationProperties("chinjto.games.dev.shell")
public record ShellMocksProperties(
        long sleep
) {}

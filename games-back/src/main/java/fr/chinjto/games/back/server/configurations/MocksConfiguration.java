package fr.chinjto.games.back.server.configurations;

import fr.chinjto.games.back.infrastructure.systems.linux.shell.impl.ShellMocksProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Configuration
@Profile("dev")
@EnableConfigurationProperties({ ShellMocksProperties.class })
public class MocksConfiguration {

}

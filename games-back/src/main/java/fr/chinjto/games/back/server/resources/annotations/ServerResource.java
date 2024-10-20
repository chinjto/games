package fr.chinjto.games.back.server.resources.annotations;

import fr.chinjto.games.back.server.resources.Action;
import fr.chinjto.games.back.server.resources.Server;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServerResource {
    Server server();
    Action action();
}

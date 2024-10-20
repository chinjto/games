package fr.chinjto.games.back.server.resources;

import fr.chinjto.games.back.server.exceptions.ResourceNotImplementedException;
import fr.chinjto.games.back.business.services.MinecraftServices;
import fr.chinjto.games.back.server.resources.annotations.ServerResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.chinjto.games.back.server.resources.Action.RESTART;
import static fr.chinjto.games.back.server.resources.Action.START;
import static fr.chinjto.games.back.server.resources.Action.STOP;
import static fr.chinjto.games.back.server.resources.Action.UPDATE;
import static fr.chinjto.games.back.server.resources.Server.MINECRAFT;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@RestController
@RequestMapping("/api/games/minecraft")
@RequiredArgsConstructor
public class MinecraftResources {

    private final MinecraftServices services;

    @PostMapping("/run")
    @ServerResource(server = MINECRAFT, action = START)
    public ResponseEntity<Void> startMinecraft() {
        this.services.start();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/run")
    @ServerResource(server = MINECRAFT, action = RESTART)
    public ResponseEntity<Void> restartMinecraft() {
        this.services.restart();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/run")
    @ServerResource(server = MINECRAFT, action = STOP)
    public ResponseEntity<Void> stopMinecraft() {
        this.services.stop();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/update")
    @ServerResource(server = MINECRAFT, action = UPDATE)
    public ResponseEntity<Void> updatePalworld() {
        throw new ResourceNotImplementedException();
    }

}

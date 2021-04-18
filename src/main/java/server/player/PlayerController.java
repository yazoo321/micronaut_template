package server.player;

import io.micronaut.http.annotation.*;
import server.player.motion.dto.PlayerMotion;
import server.player.motion.dto.PlayerMotionList;
import server.player.motion.service.PlayerMotionService;

import javax.inject.Inject;

@Controller("/player")
public class PlayerController {

    @Inject
    PlayerMotionService playerService;

    @Post("/update-motion")
    public PlayerMotionList updatePlayerLocation(@Body PlayerMotion playerMotionRequest) {
        playerService.updatePlayerState(playerMotionRequest);
        return playerService.getPlayersNearMe(playerMotionRequest.getPlayerName());
    }
}
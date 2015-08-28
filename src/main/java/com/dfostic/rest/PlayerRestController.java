package com.dfostic.rest;

import com.dfostic.beans.Player;
import com.dfostic.data.PlayerRepository;
import com.dfostic.factory.PlayerFactory;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DFostic1
 */
@Controller
@RequestMapping("/rest")
public class PlayerRestController {

    private final PlayerFactory playerFactory;

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerRestController(PlayerFactory playerFactory, PlayerRepository playerRepository) {
        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
    }

//    @RequestMapping(value="/player/getall", method=RequestMethod.GET, produces={"application/xml","application/json"})
    @RequestMapping(value = "/player/getall", method = RequestMethod.GET, produces={"application/json","application/xml"})
    public @ResponseBody
    List<Player> players(
            @RequestBody
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return playerRepository.findAll();
    }

    @Produces({"application/xml","application/json"})
    @RequestMapping(value = "/player/all", method = RequestMethod.GET, headers = {"ACCEPT=*/*"})
    public @ResponseBody
    List<Player> playersOther(
            @RequestBody
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return playerRepository.findAll();
    }
}

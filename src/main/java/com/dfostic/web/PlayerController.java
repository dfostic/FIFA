package com.dfostic.web;

import javax.validation.Valid;
import com.dfostic.beans.Player;
import org.springframework.ui.Model;
import com.dfostic.config.FifaConfig;
import com.dfostic.factory.PlayerFactory;
import com.dfostic.data.PlayerRepository;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author dfostic1
 */
@Controller
@RequestMapping("/player")
@ContextConfiguration(classes = FifaConfig.class)
public class PlayerController {

    private final PlayerFactory playerFactory;

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerFactory playerFactory, PlayerRepository playerRepository) {
        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
    }

    @RequestMapping(value = "/create", method = GET)
    public String goToCreatePlayerPage(Model model) {
        model.addAttribute(new Player());
        return "createPlayer";
    }

    @RequestMapping(value = "/create", method = POST)
    public String processRegistration(@Valid Player player, Errors errors) {
        if (errors.hasErrors()) {
            return "createPlayer";
        }

        String validation = this.playerFactory.isPlayerValid(player);
        if (!validation.isEmpty()) {
            return "createPlayer";
        }

        this.playerRepository.save(player);
        return String.format("redirect:/player/%s/%s", player.getFirstName(), player.getLastName());
    }

    @RequestMapping(value = "/{firstname}/{lastname}", method = GET)
    public String showPlayerProfile(@PathVariable String firstname, @PathVariable String lastname, Model model) {

        // When persistance will be implemented, to be added a method which finds player bu firstName and lastName
        Player requestPlayer = this.playerRepository.findByLastName(lastname).get(0);
        model.addAttribute(requestPlayer);

        return "playerProfile";
    }

    public String cancelPlayer() {
        return "/";
    }

}

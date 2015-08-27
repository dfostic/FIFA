package com.dfostic.web;

import com.dfostic.beans.Player;
import com.dfostic.config.FifaConfig;
import com.dfostic.data.PlayerRepository;
import com.dfostic.factory.PlayerFactory;
import com.dfostic.interfaces.IPlayer;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
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

    private IPlayer player;
    
    private final PlayerFactory playerFactory;

    @Autowired
    public PlayerController(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

//    @Autowired
//    private final PlayerFactory playerFactory;
//
////    @Autowired
////    private PlayerRepository playerRepository;
//
//    /* Workaround for unit tests*/
//    public PlayerController() {
//        this.playerFactory = new PlayerFactory();
//    }
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

//        this.playerRepository.save(player);
        this.player = player;
        return String.format("redirect:/player/%s/%s", player.getFirstName(), player.getLastName());
    }

    @RequestMapping(value = "/{firstname}/{lastname}", method = GET)
    public String showPlayerProfile(@PathVariable String firstname, @PathVariable String lastname, Model model) {

        // When persistance will be implemented, to be added a method which finds player bu firstName and lastName
//        Player requestPlayer = this.playerRepository.findByLastName(lastname).get(0);
        model.addAttribute(this.player);

//        model.addAttribute(this.player);
        return "playerProfile";
    }

    public String cancelPlayer() {
        return "/";
    }

}

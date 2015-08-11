package com.dfostic.web;

import com.dfostic.beans.Player;
import com.dfostic.config.FifaConfig;
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
public class CreatePlayerController {

    private IPlayer player;

    @Autowired
    private PlayerFactory playerFactory;
    
    @Autowired
    private PlayerModifierImpl playerModifier; 

    @RequestMapping(value = "/create", method = GET)
    public String goToCreatePlayerPage() {
        return "createPlayer";
    }

    @RequestMapping(value = "/create", method = POST)
    public String processRegistration(@Valid Player player, Errors errors) {
        
        System.out.println("\n ----- Inside Create Player ----- \n");
        
        if (errors.hasErrors()) {
            return "createPlayer";
        }
        
        // FOR DEBUGGING
        int goals = player.getStatistics().getGoals();
        System.out.println("\n Goals scored: " + goals);
        int bookings = player.getStatistics().getBookings();
        System.out.println("\n Bookings earned: " + bookings);
        //
        
        String validation = this.playerFactory.isPlayerValid(player);        
        if (!validation.isEmpty()){
            return "createPlayer";
        }
        
        this.player = player;        
        return String.format("redirect:/player/%s/%s", player.getFirstName(), player.getLastName());
    }

    @RequestMapping(value = "/{firstname}/{lastname}", method = GET)
    public String showPlayerProfile(@PathVariable String firstname, @PathVariable String lastname, Model model) {
        String test = "checkPoint";

        // When persistance will be implemented, to be added a method which finds player bu firstName and lastName
        model.addAttribute(this.player);
        return "playerProfile";
    }
    
    public String cancelPlayer() {
        return "/";
    }

}

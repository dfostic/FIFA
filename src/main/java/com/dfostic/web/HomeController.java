package com.dfostic.web;

import java.util.List;
import com.dfostic.beans.Player;
import com.dfostic.data.PlayerRepository;
import com.dfostic.factory.PlayerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {    

    private final PlayerRepository playerRepository;
    
    @Autowired
    public HomeController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;       
        
        this.playerRepository.save(PlayerFactory.BenjaminStambouli);
        this.playerRepository.save(PlayerFactory.ThiagoSilva);
        this.playerRepository.save(PlayerFactory.NicolasDouchez);
        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        
        List<Player> playerList = this.playerRepository.findAll();
        
        ModelAndView model = new ModelAndView("home");
        model.addObject("playerList", playerList);        
        return model;
    }

}

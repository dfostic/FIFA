package com.dfostic.rest;

import com.dfostic.beans.Player;
import com.dfostic.data.PlayerRepository;
import com.dfostic.factory.PlayerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DFostic1
 */
@Controller
@RequestMapping("/rest/player")
public class PlayerRestController {

    private final PlayerFactory playerFactory;

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerRestController(PlayerFactory playerFactory, PlayerRepository playerRepository) {
        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
    }

//    @RequestMapping(value="/getall", method=RequestMethod.GET, produces={"application/xml","application/json"})
    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Player> players(
            @RequestBody
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return playerRepository.findAll();
    }

//    @Produces({"application/json", "application/xml"})
//    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = {"ACCEPT=*/*"})
//    public @ResponseBody
//    List<Player> playersOther(
//            @RequestBody
//            @RequestParam(value = "count", defaultValue = "20") int count) {
//        return playerRepository.findAll();
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView viewAllPlayers() throws IOException {        
        ObjectMapper mapper = new ObjectMapper();        
        List<Player> allPlayers = this.playerRepository.findAll();
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String playerString = ow.writeValueAsString(allPlayers);

        Object json = mapper.readValue(playerString, Object.class);        

        ModelAndView modelandView = new ModelAndView("viewPlayers");

        modelandView.addObject("output", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

        return modelandView;
    }
    
    @RequestMapping(value = "/lastName/{lastName}", method = RequestMethod.GET)
    public ModelAndView viewPlayer(@PathVariable String lastName) throws IOException {        
        ObjectMapper mapper = new ObjectMapper();        
        List<Player> players = this.playerRepository.findByLastName(lastName);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String playerString = ow.writeValueAsString(players);

        Object json = mapper.readValue(playerString, Object.class);        

        ModelAndView modelandView = new ModelAndView("viewPlayers");

        modelandView.addObject("output", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

        return modelandView;
    }
    
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ModelAndView viewPlayerById(@PathVariable long id) throws IOException {
        
//        long longId = Long.parseLong(id);
        ObjectMapper mapper = new ObjectMapper();        
        Player player = this.playerRepository.findOne(id);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String playerString = ow.writeValueAsString(player);

        Object json = mapper.readValue(playerString, Object.class);        

        ModelAndView modelandView = new ModelAndView("viewPlayers");

        modelandView.addObject("output", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

        return modelandView;
    }
    

}

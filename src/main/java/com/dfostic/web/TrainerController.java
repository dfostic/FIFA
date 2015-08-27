package com.dfostic.web;

import com.dfostic.beans.Trainer;
import com.dfostic.config.FifaConfig;
import com.dfostic.factory.TrainerFactory;
import com.dfostic.interfaces.ITrainer;
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
@RequestMapping("/trainer")
@ContextConfiguration(classes = FifaConfig.class)
public class TrainerController {

    private ITrainer trainer;

    @Autowired
    private final TrainerFactory trainerFactory;

    /* Workaround for unit tests*/
    public TrainerController() {
        this.trainerFactory = new TrainerFactory();
    }

    @RequestMapping(value = "/create", method = GET)
    public String goToCreateTrainerPage() {
        return "createTrainer";
    }
    
    @RequestMapping(value = "/create", method = POST)
    public String processRegistration(@Valid Trainer trainer, Errors errors) {

        if (errors.hasErrors()) {
            return "createTrainer";
        }
        
        String validation = this.trainerFactory.isTrainerValid(trainer);
        if (!validation.isEmpty()) {
            return "createTrainer";
        }
        
        this.trainer = trainer;
        return String.format("redirect:/trainer/%s/%s", trainer.getFirstName(), trainer.getLastName());
    }
    
    @RequestMapping(value = "/{firstname}/{lastname}", method = GET)
    public String showPlayerProfile(@PathVariable String firstname, @PathVariable String lastname, Model model) {

        // When persistance will be implemented, to be added a method which finds player bu firstName and lastName
        model.addAttribute(this.trainer);
        return "trainerProfile";
    }
    
    public String cancelTrainer() {
        return "/";
    }
}

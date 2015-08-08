package com.dfostic.web;

import com.dfostic.factory.TrainerFactory;
import com.dfostic.interfaces.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author dfostic1
 */
@Controller
@RequestMapping(value = "/trainer")
public class CreateTrainerController {

    private ITrainer trainer;

    @Autowired
    private TrainerFactory trainerFactory;

    @RequestMapping(value = "create", method = GET)
    public String goToCreateTrainerPage() {
        return "createTrainer";
    }

}

package com.dfostic.config;

import com.dfostic.beans.Player;
import com.dfostic.beans.Trainer;
import com.dfostic.factory.PlayerFactory;
import com.dfostic.factory.TeamFactory;
import com.dfostic.factory.TrainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author dfostic
 */
@Configuration
@ComponentScan(basePackageClasses = {PlayerFactory.class, TrainerFactory.class, TeamFactory.class})
public class FifaConfig {

    @Bean(name = "NicolasDouchez")
    public Player getNicolasDouchez() {
        return PlayerFactory.NicolasDouchez;
    }

    @Bean(name = "ThiagoSilva")
    public Player getThiagoSilva() {
        return PlayerFactory.ThiagoSilva;
    }

    @Bean(name = "BenjaminStambouli")
    public Player getBenjaminStambouli() {
        return PlayerFactory.BenjaminStambouli;
    }
    
    @Bean(name = "LaurentBlanc")
    public Trainer getLaurentBlanc() {
        return TrainerFactory.LaurentBlanc;
    }
    
    @Bean(name = "LuisEnrique")
    public Trainer getLuisEnrique() {
        return TrainerFactory.LuisEnrique;
    }
    
    @Bean(name = "JoseMourinho")
    public Trainer getJoseMourinho() {
        return TrainerFactory.JoseMourinho;
    }
    
    @Bean(name = "RafaelBenitez")
    public Trainer getRafaelBenitez() {
        return TrainerFactory.RafaelBenitez;
    }
}

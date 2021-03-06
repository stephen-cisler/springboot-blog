package com.codeup.springbootblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dicePage(Model viewModel) {
        System.out.println("roll dice main");
        viewModel.addAttribute("rollPick", true);
        return "diceRoll";
    }

    @GetMapping("/roll-dice/{guess}")
    public String diceGuess(@PathVariable String guess, Model viewModel) {
        System.out.println("roll dice guesses");
        int roll = new Random().nextInt(6 - 1) +1;
        boolean correctGuess = (roll == Integer.parseInt(guess));
        viewModel.addAttribute("rollPick", false);
        viewModel.addAttribute("correctGuess", correctGuess);
        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("roll", roll);
        return "diceRoll";
    }

}

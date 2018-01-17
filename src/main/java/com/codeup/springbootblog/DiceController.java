package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dicePage(Model viewModel) {
        viewModel.addAttribute("rollPick", true);
        return "diceRoll";
    }

    @GetMapping("/roll-dice/{guess}")
    public String diceGuess(@PathVariable String guess, Model viewModel) {
        int roll = new Random().nextInt(6 - 1) +1;
        boolean correctGuess = (roll == Integer.parseInt(guess));
        viewModel.addAttribute("rollPick", true);
        viewModel.addAttribute("correctGuess", correctGuess);
        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("roll", roll);
        return "diceRoll";
    }

}

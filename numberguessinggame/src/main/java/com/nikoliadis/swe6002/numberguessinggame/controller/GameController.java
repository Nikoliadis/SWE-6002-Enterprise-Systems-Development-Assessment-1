package com.nikoliadis.swe6002.numberguessinggame.controller;

import com.nikoliadis.swe6002.numberguessinggame.model.GameResult;
import com.nikoliadis.swe6002.numberguessinggame.service.GameService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("playerName", "");
        return "index";
    }

    @PostMapping("/start")
    public String startGame(@RequestParam String playerName, HttpSession session) {
        int targetNumber = gameService.generateRandomNumber();
        session.setAttribute("playerName", playerName);
        session.setAttribute("targetNumber", targetNumber);
        session.setAttribute("attempts", 0);
        return "redirect:/game";
    }

    @GetMapping("/game")
    public String game(HttpSession session, Model model) {
        String playerName = (String) session.getAttribute("playerName");
        if (playerName == null) {
            return "redirect:/";
        }
        model.addAttribute("playerName", playerName);
        model.addAttribute("message", "Κάνε μία πρόβλεψη (1–100)");
        return "game";
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam int guess, HttpSession session, Model model) {
        String playerName = (String) session.getAttribute("playerName");
        Integer targetNumber = (Integer) session.getAttribute("targetNumber");
        Integer attempts = (Integer) session.getAttribute("attempts");

        if (playerName == null || targetNumber == null || attempts == null) {
            return "redirect:/";
        }

        attempts++;
        session.setAttribute("attempts", attempts);

        String message;
        boolean correct = false;

        if (guess < targetNumber) {
            message = "Too Low!";
        } else if (guess > targetNumber) {
            message = "Too High!";
        } else {
            message = "Correct!";
            correct = true;
        }

        model.addAttribute("playerName", playerName);
        model.addAttribute("guess", guess);
        model.addAttribute("message", message);
        model.addAttribute("attempts", attempts);

        if (correct) {
            gameService.saveResult(playerName, attempts, targetNumber);
            List<GameResult> results = gameService.getResultsForPlayer(playerName);
            model.addAttribute("results", results);
            return "result";
        }

        return "game";
    }

    @PostMapping("/restart")
    public String restart(HttpSession session) {
        String playerName = (String) session.getAttribute("playerName");
        if (playerName == null) {
            return "redirect:/";
        }
        int targetNumber = gameService.generateRandomNumber();
        session.setAttribute("targetNumber", targetNumber);
        session.setAttribute("attempts", 0);
        return "redirect:/game";
    }
}

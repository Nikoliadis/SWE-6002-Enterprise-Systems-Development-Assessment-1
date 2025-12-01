package com.nikoliadis.swe6002.numberguessinggame.service;

import com.nikoliadis.swe6002.numberguessinggame.model.GameResult;
import com.nikoliadis.swe6002.numberguessinggame.repository.GameResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private final GameResultRepository gameResultRepository;
    private final Random random = new Random();

    public GameService(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    public int generateRandomNumber() {
        return random.nextInt(100) + 1; // 1–100
    }

    public GameResult saveResult(String playerName, int attempts, int targetNumber) {
        GameResult result = new GameResult(playerName, attempts, targetNumber);
        return gameResultRepository.save(result);
    }

    public List<GameResult> getResultsForPlayer(String playerName) {
        return gameResultRepository.findByPlayerNameOrderByPlayedAtDesc(playerName);
    }
}

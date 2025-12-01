package com.nikoliadis.swe6002.numberguessinggame.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private int attempts;
    private int targetNumber;
    private LocalDateTime playedAt;

    public GameResult() {
    }

    public GameResult(String playerName, int attempts, int targetNumber) {
        this.playerName = playerName;
        this.attempts = attempts;
        this.targetNumber = targetNumber;
        this.playedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }
}

package com.nikoliadis.swe6002.numberguessinggame.repository;

import com.nikoliadis.swe6002.numberguessinggame.model.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameResultRepository extends JpaRepository<GameResult, Long> {

    List<GameResult> findByPlayerNameOrderByPlayedAtDesc(String playerName);
}

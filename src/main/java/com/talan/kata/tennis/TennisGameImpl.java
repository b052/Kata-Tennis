package com.talan.kata.tennis;

import java.util.List;

public class TennisGameImpl implements TennisGame{
    private String player1;
    private String player2;
    private int player1Score = 0;
    private int player2Score = 0;
    public TennisGameImpl(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void wonPoint(String playerName) {
        if(playerName.equals(this.player1))
            this.player1Score++;
        if((playerName.equals(this.player2)))
            this.player2Score++;
    }

    @Override
    public String getScore() {
        List<String> scoresFromZeroToThreePoints = List.of("Love", "Fifteen", "Thirty", "Forty");
        String result = "";
        if (hasSameScore()) {
            if (this.player1Score < 3)
                result = scoresFromZeroToThreePoints.get(player1Score) + "-All";
            else
                result = "Deuce";
        } else if ((Math.max(this.player1Score, this.player2Score) >= scoresFromZeroToThreePoints.size())) {
            if (Math.abs(this.player1Score - this.player2Score) == 1)
                result = "Advantage " + (isPlayer1Winning() ? player1 : player2);
            else
                result = "Win for " + (isPlayer1Winning() ? player1 : player2);
        } else
            result = scoresFromZeroToThreePoints.get(player1Score) + "-" + scoresFromZeroToThreePoints.get(player2Score);

        return result;
    }

    private boolean isPlayer1Winning() {
        return this.player1Score > this.player2Score;
    }

    private boolean hasSameScore() {
        return this.player1Score == this.player2Score;
    }
}

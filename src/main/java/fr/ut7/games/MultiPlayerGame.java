package fr.ut7.games;


import java.util.ArrayList;

public class MultiPlayerGame {
    private ArrayList<String> players;

    public static final int PLAYER_NUMBER = 2;

    public MultiPlayerGame() {
        players = new ArrayList<String>();
    }

    public MultiPlayerGame(ArrayList<String> initialPlayers) throws NoPlayerException {
        players = initialPlayers;
        if (notEnoughPlayer(initialPlayers)) {
            throw new NoPlayerException();
        }
    }

    public ArrayList<String> players() {
        return players;
    }

    public String winner() {
        return players().get(0);
    }

    public void addPlayer(String playerName) {
        players().add(playerName);
    }

    public String getNextPlayer(int tour) {
        return players().get(tour % 2);
    }

    private boolean notEnoughPlayer(ArrayList<String> players) {
        return players.size() != PLAYER_NUMBER;
    }
}

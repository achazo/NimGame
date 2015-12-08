package fr.ut7.games;

import java.util.ArrayList;

public class NimGame {
    private int stickNumber;
    private String lastPlayer;
    private ArrayList<String> players;

    public NimGame(ArrayList<String> initialPlayers, int initialStickNumber) throws NoPlayerException {
        stickNumber = initialStickNumber;
        if (initialPlayers.size() != 2) {
            throw new NoPlayerException();
        }
        players = initialPlayers;
    }

    public String winner() {
        if (stickNumber <= 0) {
            if (lastPlayer.equals(players.get(0))) {
                return players.get(1);
            } else if (lastPlayer.equals(players.get(1))) {
                return players.get(0);
            }
        }
        return "";
    }

    public void play(String player, int stickToRemove) {
        lastPlayer = player;
        stickNumber = stickNumber - stickToRemove;
    }
}

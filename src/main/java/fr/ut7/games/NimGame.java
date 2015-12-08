package fr.ut7.games;

import java.util.ArrayList;

public class NimGame {
    public static final int PLAYER_NUMBER = 2;
    public static final String NO_WINNER = "";

    private int stickNumber;
    private String lastPlayer;
    private ArrayList<String> players;

    public NimGame(ArrayList<String> initialPlayers, int initialStickNumber) throws NoPlayerException {
        stickNumber = initialStickNumber;
        if (notEnoughPlayer(initialPlayers)) {
            throw new NoPlayerException();
        }
        players = initialPlayers;
    }

    public NimGame(int initialStickNumber) {
        stickNumber = initialStickNumber;
        players = new ArrayList<String>();
    }

    public String winner() {
        if (noMoreStick()) return getSecondToLast();
        return NO_WINNER;
    }

    public void play(String player, int stickToRemove) {
        lastPlayer = player;
        stickNumber = stickNumber - stickToRemove;
    }

    public boolean play(String player, String stickToRemoveString) {
        try {
            play(player, Integer.parseInt(stickToRemoveString));
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public ArrayList<String> players() {
        return players;
    }

    private String getSecondToLast() {
        if (lastPlayer.equals(players.get(0))) {
            return players.get(1);
        }
        return players.get(0);
    }

    private boolean noMoreStick() {
        return stickNumber <= 0;
    }

    private boolean notEnoughPlayer(ArrayList<String> players) {
        return players.size() != PLAYER_NUMBER;
    }

    public String getNextPlayer(int tour) {
        return players.get(tour % 2);
    }

    public int availableSticks() {
        return stickNumber;
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
    }
}

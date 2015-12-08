package fr.ut7.games;

import java.util.ArrayList;

public class NimGame extends MultiPlayerGame {
    public static final String NO_WINNER = "";

    private int stickNumber;

    public NimGame(ArrayList<String> initialPlayers, int initialStickNumber) throws NoPlayerException {
        super(initialPlayers);
        stickNumber = initialStickNumber;

    }

    public NimGame(int initialStickNumber) {
        super();
        stickNumber = initialStickNumber;
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

    public int availableSticks() {
        return stickNumber;
    }

    private boolean noMoreStick() {
        return stickNumber <= 0;
    }

    @Override
    public String winner() {
        if (noMoreStick()) return getSecondToLast();
        return NO_WINNER;
    }


    private String lastPlayer;

    private String getSecondToLast() {
        if (lastPlayer.equals(players().get(0))) {
            return players().get(1);
        }
        return players().get(0);
    }

}

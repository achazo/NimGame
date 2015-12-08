package fr.ut7.games;

import java.util.ArrayList;

public interface Game {

    ArrayList<String> players();
    void addPlayer(String player);

    void play(String player, int value);
    String winner();

    String justAWord();
}

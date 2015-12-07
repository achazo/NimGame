package fr.ut7.games;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NimGameTest {

    @Test
    public void noWinnerWhenGameStart() {
        NimGame game = new NimGame();
        assertEquals("", game.winner());
    }
}

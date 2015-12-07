package fr.ut7.games;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lapboss on 07/12/15.
 */
public class NimGameTest {

    @Test
    public void noWinnerWhenGameStart() {
        NimGame game = new NimGame();
        assertEquals("", game.winner());
    }
}

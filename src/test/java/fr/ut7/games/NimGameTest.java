package fr.ut7.games;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NimGameTest {

    @Test
    public void noWinnerWhenGameStart() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("joueur1");
        players.add("joueur2");
        NimGame game = new NimGame(players, 1) ;
        assertEquals("", game.winner());
    }

    @Test
    public void playerOneWin() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("joueur1");
        players.add("joueur2");
        NimGame game = new NimGame(players, 4);
        game.play("joueur1", 3);
        game.play("joueur2", 1);
        assertEquals("joueur1", game.winner());
    }

    @Test
    public void playerTwoWin() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("joueur1");
        players.add("joueur2");
        NimGame game = new NimGame(players, 2);
        game.play("joueur1", 2);
        assertEquals("joueur2", game.winner());
    }

    @Test
    public void withoutTwoPLayerThrowException() {
        try {
            NimGame game = new NimGame(new ArrayList<String>(), 12);
            fail("No player exception expected");
        } catch (NoPlayerException pasdejoueur) {
            assertThat(pasdejoueur.getMessage(), is("Il faut deux joueurs"));
        }
    }

    @Test
    public void canPlayWithAString() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("j1");
        players.add("j2");
        NimGame game = new NimGame(players, 10);
        assertTrue(game.play("j1", "2"));
    }

    @Test
    public void cantPlayWithAStringNotANumber() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("j1");
        players.add("j2");
        NimGame game = new NimGame(players, 10);
        assertFalse(game.play("j1", "e"));
    }

}

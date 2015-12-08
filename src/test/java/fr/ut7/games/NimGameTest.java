package fr.ut7.games;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NimGameTest {

    private ArrayList<String> players;
    private NimGame game;

    @Before
    public void setUp() throws NoPlayerException {
        players = new ArrayList<String>();
        players.add("joueur1");
        players.add("joueur2");
        game = new NimGame(players, 10);
    }

    @Test
    public void noWinnerWhenGameStart() {
        assertEquals("", game.winner());
    }

    @Test
    public void playerOneWin() throws NoPlayerException {
        game = new NimGame(players, 4);
        game.play("joueur1", 3);
        game.play("joueur2", 1);
        assertEquals("joueur1", game.winner());
    }

    @Test
    public void playerTwoWin() throws NoPlayerException {
        game = new NimGame(players, 2);
        game.play("joueur1", 2);
        assertEquals("joueur2", game.winner());
    }

    @Test
    public void withoutTwoPLayerThrowException() {
        try {
            game = new NimGame(new ArrayList<String>(), 12);
            fail("No player exception expected");
        } catch (NoPlayerException pasdejoueur) {
            assertThat(pasdejoueur.getMessage(), is("Il faut deux joueurs"));
        }
    }

    @Test
    public void canPlayWithAString() {
        assertTrue(game.play("j1", "2"));
    }

    @Test
    public void cantPlayWithAStringNotANumber() {
        assertFalse(game.play("j1", "e"));
    }

    @Test
    public void getPlayers() {
        assertEquals(players, game.players());
    }

    @Test
    public void nextPLayerForRound1IsFirstPlayer() {
        assertEquals(players.get(0), game.getNextPlayer(0));
    }

    @Test
    public void nextPLayerForRound2IsSecondPlayer() {
        assertEquals(players.get(1), game.getNextPlayer(1));
    }

    @Test
    public void availableSticks() throws NoPlayerException {
        game = new NimGame(players, 10);
        assertEquals(10, game.availableSticks());
        game.play(players.get(0), 2);
        assertEquals(8, game.availableSticks());
    }

    @Test
    public void addPlayerInGame() throws NoPlayerException {
        game = new NimGame(10);
        game.addPlayer("joueur1");
        assertTrue(game.players().contains("joueur1"));
    }
}

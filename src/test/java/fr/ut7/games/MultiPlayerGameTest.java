package fr.ut7.games;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MultiPlayerGameTest {

    @Test
    public void noPlayersAtStart() {
        MultiPlayerGame game = new MultiPlayerGame();
        assertEquals(0, game.players().size());
    }

    @Test
    public void canInitializePlayersAtStart() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("toto");
        players.add("tata");
        MultiPlayerGame game = new MultiPlayerGame(players);
        assertEquals(2, game.players().size());
    }

    @Test
    public void firstPlayerIsWinnerByDefault() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("toto");
        players.add("tata");
        MultiPlayerGame game = new MultiPlayerGame(players);
        assertEquals("toto", game.winner());
    }

    @Test
    public void addPlayerInGame() throws NoPlayerException {
        MultiPlayerGame game = new MultiPlayerGame();
        game.addPlayer("joueur1");
        assertTrue(game.players().contains("joueur1"));
    }

    @Test
    public void nextPLayerForRound1IsFirstPlayer() throws NoPlayerException {

        ArrayList<String> players = new ArrayList<String>();
        players.add("toto");
        players.add("tata");
        MultiPlayerGame game = new MultiPlayerGame(players);
        assertEquals(players.get(0), game.getNextPlayer(0));
    }

    @Test
    public void nextPLayerForRound2IsSecondPlayer() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("toto");
        players.add("tata");
        MultiPlayerGame game = new MultiPlayerGame(players);
        assertEquals(players.get(1), game.getNextPlayer(1));
    }

    @Test
    public void getPlayers() throws NoPlayerException {
        ArrayList<String> players = new ArrayList<String>();
        players.add("toto");
        players.add("tata");
        MultiPlayerGame game = new MultiPlayerGame(players);
        assertEquals(players, game.players());
    }

    @Test
    public void withoutTwoPLayerThrowException() {
        try {
            MultiPlayerGame game = new MultiPlayerGame(new ArrayList<String>());
            fail("No player exception expected");
        } catch (NoPlayerException pasdejoueur) {
            assertThat(pasdejoueur.getMessage(), is("Il faut deux joueurs"));
        }
    }
}

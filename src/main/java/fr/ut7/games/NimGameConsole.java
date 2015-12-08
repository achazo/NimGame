package fr.ut7.games;

import java.util.ArrayList;

public class NimGameConsole {

    public static void main(String[] args) throws NoPlayerException {
        System.out.println("Ici c'est pour tester des trucs");

        NimGame game = new NimGame(10);
        game.addPlayer(getPlayerName());
        game.addPlayer(getPlayerName());
        gameLoop(game);
    }

    private static void gameLoop(NimGame game) {
        int tour = 0;
        while(noWinner(game)) {
            System.out.println("Ceci est le tour numéro : " + tour);
            System.out.println("Il reste " + game.availableSticks() + " allumettes");
            String player = game.getNextPlayer(tour);
            System.out.println(player + " c'est ton tour");

            String stickToRemove = System.console().readLine();
            if (!game.play(player, stickToRemove)) {
                System.out.println("Je n'ai pas réussi à enlever " + stickToRemove + " allumettes");
                continue;
            }
            tour += 1;
        }
        System.out.println("C'est " + game.winner() + " qui a gagné");
    }

    private static String getPlayerName() {
        System.out.println("Entrez le nom d'un joueur : ");
        String playerName = System.console().readLine();
        System.out.println("Bonjour " + playerName);
        return playerName;
    }

    private static boolean noWinner(NimGame game) {
        return game.winner().equals("");
    }
}

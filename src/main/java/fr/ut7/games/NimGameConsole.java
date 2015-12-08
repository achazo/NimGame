package fr.ut7.games;

import java.util.ArrayList;

public class NimGameConsole {

    public static void main(String[] args) throws NoPlayerException {
        System.out.println("Ici c'est pour tester des trucs");

        ArrayList<String> players = new ArrayList<String>();
        players.add(getPlayerName());
        players.add(getPlayerName());
        NimGame game = new NimGame(players, 10);
        gameLoop(players, game);
    }

    private static void gameLoop(ArrayList<String> players, NimGame game) {
        int tour = 0;
        while(noWinner(game)) {
            String player = getNextPlayer(players, tour);
            String stickToRemove = System.console().readLine();
            if (!game.play(player, stickToRemove)) {
                System.out.println("Je n'ai pas réussi à enlever " + stickToRemove + " allumettes");
                continue;
            }
            tour += 1;
        }
        System.out.println("C'est " + game.winner() + " qui a gagné");
    }

    private static String getNextPlayer(ArrayList<String> players, int tour) {
        System.out.println("Ceci est le tour numéro : " + tour);
        String joueur = players.get(tour % 2);
        System.out.println(joueur + " c'est ton tour");
        return joueur;
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

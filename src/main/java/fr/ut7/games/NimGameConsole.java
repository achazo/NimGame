package fr.ut7.games;

import java.util.ArrayList;

public class NimGameConsole {

    public static void main(String[] args) throws NoPlayerException {
        System.out.println("Ici c'est pour tester des trucs");
        ArrayList<String> players = new ArrayList<String>();
        players.add("Joueur 1");
        players.add("Joueur 2");
        NimGame game = new NimGame(players, 10);

        int tour = 0;
        String joueur;
        while(game.winner().equals("")) {
            System.out.println("Ceci est le tour numéro : " + tour);
            joueur = players.get(tour % 2);
            System.out.println(joueur + " c'est ton tour");
            String input = System.console().readLine();
            game.play(joueur, Integer.parseInt(input));
            System.out.println(game.winner());
            tour += 1;
        }
    }
}

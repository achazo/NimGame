package fr.ut7.games;

import java.util.ArrayList;

public class NimGameConsole {

    public static void main(String[] args) throws NoPlayerException {
        System.out.println("Ici c'est pour tester des trucs");

        ArrayList<String> players = new ArrayList<String>();

        System.out.println("Entrez le nom du joueur 1 : ");
        String nomJoueur1 = System.console().readLine();
        System.out.println("Bonjour " + nomJoueur1);
        players.add(nomJoueur1);
        System.out.println("Entrez le nom du joueur 2 : ");
        String nomJoueur2 = System.console().readLine();
        System.out.println("Bonjour " + nomJoueur2);
        players.add(nomJoueur2);

        NimGame game = new NimGame(players, 10);

        int tour = 0;
        String joueur;
        while(game.winner().equals("")) {
            System.out.println("Ceci est le tour numéro : " + tour);
            joueur = players.get(tour % 2);
            System.out.println(joueur + " c'est ton tour");
            String input = System.console().readLine();
            game.play(joueur, Integer.parseInt(input));
            System.out.println("C'est " + game.winner() + " qui a gagné");
            tour += 1;
        }
    }
}

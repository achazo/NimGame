package fr.ut7.games;

public class NoPlayerException extends Throwable {

    public NoPlayerException() {
        super("Il faut deux joueurs");
    }
}

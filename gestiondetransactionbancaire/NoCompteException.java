package gestiondetransactionbancaire;


class NoCompteException extends Exception {
    public NoCompteException(String message) {
        super(message);
    }
}
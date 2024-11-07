package gestiondetransactionbancaire;


class NegativeDeviseException extends Exception {
    public NegativeDeviseException(String message) {
        super(message);
    }
}
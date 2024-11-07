package gestiondetransactionbancaire;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Compte {
    private String numCompte;
    private Date dateCreation;
    private Date dateUpdate;
    private long devise;
    private Banque banque;
    private List<Transaction> transactions;

    // Parameterized Constructor

    public Compte(String numCompte, Banque banque, long devise) throws NegativeDeviseException {
        this.numCompte = numCompte;
        this.dateCreation = new Date();
        this.dateUpdate = new Date();
        this.banque = banque;
        this.transactions = new ArrayList<>();
        setDevise(devise);
    }

    // Getters
    public String getNumCompte() { return numCompte; }
    public Date getDateCreation() { return dateCreation; }
    public Date getDateUpdate() { return dateUpdate; }
    public long getDevise() { return devise; }
    public Banque getBanque() { return banque; }

    // Setter for devise with exception handling and dateUpdate change
    public void setDevise(long devise) throws NegativeDeviseException {
        if (devise < 0) {
            throw new NegativeDeviseException("Devise cannot be negative");
        }
        this.devise = devise;
        this.dateUpdate = new Date();
    }

    // Manage Transaction relationship
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
}

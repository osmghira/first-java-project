package gestiondetransactionbancaire;

import java.util.ArrayList;
import java.util.List;

class Banque {
    private int id;
    private String pays;
    private List<Compte> comptes;

    // Parameterized Constructor
    public Banque(int id, String pays) {
        this.id = id;
        this.pays = pays;
        this.comptes = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getPays() { return pays; }

    // Manage Compte relationship
    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

    public List<Compte> getComptes() {
        return comptes;
    }
}
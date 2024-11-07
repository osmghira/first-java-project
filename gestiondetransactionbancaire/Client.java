package gestiondetransactionbancaire;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gestiondetransactionbancaire.NoCompteException;

class Client {
    private String numClient;
    private String nom;
    private String adresse;
    private String phone;
    private String email;
    private List<Compte> comptes;  

    // Parameterized Constructor

    public Client(String numClient, String nom, String adresse, String phone, String email) {
        this.numClient = numClient;
        this.nom = nom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
        this.comptes = new ArrayList<>();
    }

    // Getters and Setters

    public String getNumClient() { return numClient; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    // Manage Compte relationship
    public void addCompte(Compte compte) {
        comptes.add(compte);
    }

     public void removeCompte(Compte compte) throws NoCompteException {
        if (comptes.size() <= 1) {
            throw new NoCompteException("Cannot remove the last account from the client.");
        }
        comptes.remove(compte);
    }
    //return compte liste
    
    public List<Compte> getComptes() {
        return comptes;
    }
}

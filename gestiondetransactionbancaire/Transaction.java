package gestiondetransactionbancaire;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import TypeTransaction ;
import NegativeDeviseException ;

final class Transaction {
    private TypeTransaction type;
    private Date timeStamp;
    private int reference;
    private double montant;
    private Compte senderCompte;   // The account making the payment
    private Compte receiverCompte; // The account receiving the payment

    // Parameterized Constructor
    public Transaction(TypeTransaction type, Date timeStamp, int reference,double montant, Compte senderCompte, Compte receiverCompte) {
        this.type = type;
        this.timeStamp = timeStamp;
        this.reference = reference;
        this.montant = montant;
        this.senderCompte = senderCompte;
        this.receiverCompte = receiverCompte;
        //modifier le devise de sender et si l'operation s'effectue avec succes modifier le devise de ricever selon le type de transaction
        this.effectuerverment(type,montant);
        // Associate the transaction with both sender and receiver accounts
        senderCompte.addTransaction(this);
        receiverCompte.addTransaction(this);
    }

    // Getters
    public TypeTransaction getType() { return type; }
    public Date getTimeStamp() { return timeStamp; }
    public int getReference() { return reference; }
    public Compte getSenderCompte() { return senderCompte; }
    public Compte getReceiverCompte() { return receiverCompte; }
    

    //
    public void effectuerverment(type,montant) throws NegativeDeviseException  {
        double tauxoperation;
        switch (type){
            case VIRIN :{
                tauxoperation=2/100;
                break;}
            case VIREST :{
                tauxoperation=5/100;
                break;}
            case VIRCHAC :{
                tauxoperation=10/100;
                break;}
            
            
        }
        double newsenderdevise=this.senderCompte.getDevise() - (montant*(1+tauxoperation));
        double newreceiverCompte=this.receiverCompte.getDevise() + montant;
        this.senderCompte.setDevise(newsenderdevise);

        this.receiverCompte.setDevise(newreceiverCompte);



    }
}
